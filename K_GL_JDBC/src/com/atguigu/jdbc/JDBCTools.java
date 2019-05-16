package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JDBCTools {
	
	
	/**
	 * 使用 PreparedStatement 将有效的解决 SQL 注入问题.
	 */
	@Test
	public void testPreparesStatement2() {
		String username = "a' OR PASSWORD = ";
		String password = " OR '1'='1";

		String sql = "SELECT * FROM users WHERE username = ? "
				+ "AND password = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("登录成功!");
			} else {
				System.out.println("用户名和密码不匹配或用户名不存在. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection); 
		}
	}
	/**
	 * sql 注入
	 * */
	@Test
	public void testPreparesStatement() {
		String user = "a' or password = ";
		String password = "or '1' = '1";
		String sql  = "select * from users "
				+ "where username = '"+ user
				+"' and password = '"+password+"' ";
		System.out.println(sql);
		Connection  connection= null;
		Statement statement = null;
		ResultSet	resultSet = null;
		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("用户名 密码错误");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCTools.relesaeDB(resultSet, statement, connection);
		}
	}
	
	public static void update(String sql,Object ... args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCTools.getConnection();
			pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pStatement.setObject(i+1,args[i]);				
			}
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCTools.relesaeDB(null, pStatement, connection);
		}
	}
	/**
	 * 执行Sql 的方法 insert update delete
	 */
	public static void update(String sql) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			relesaeDB(null, statement, connection);
		}
	}

	/**
	 * 释放数据库资源
	 */
	public static void relesaeDB(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 获取数据库连接的方法
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		String driverClass = properties.getProperty("dirver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Class.forName(driverClass);
		Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
}
