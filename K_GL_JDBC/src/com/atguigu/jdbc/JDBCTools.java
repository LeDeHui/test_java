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
	 * ʹ�� PreparedStatement ����Ч�Ľ�� SQL ע������.
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
				System.out.println("��¼�ɹ�!");
			} else {
				System.out.println("�û��������벻ƥ����û���������. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection); 
		}
	}
	/**
	 * sql ע��
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
				System.out.println("��½�ɹ�");
			}else {
				System.out.println("�û��� �������");
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
	 * ִ��Sql �ķ��� insert update delete
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
	 * �ͷ����ݿ���Դ
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
	 * ��ȡ���ݿ����ӵķ���
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
