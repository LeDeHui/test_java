package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class ReviewTest {
	/**
	 * 1.ResultSet 封装JDBC的查询结果
	 */
	@Test
	public void testResultSet() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			String sql = "select ID, NAME, EMAIL, BIRTHDAY from TABLE_TEST";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				String birthday = resultSet.getString(4);
				System.out.println(id + "--" + name + "--" + email + "--" + birthday);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			relesaeDB(resultSet, statement, connection);
		}
	}

	/**
	 * 1.Statement 是用于SQL的对象
	 * 
	 */
	@Test
	public void TestStement() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			String sql = "insert into table_test(ID, NAME, EMAIL, BIRTHDAY) values(6,'yuanfang','183@163.com','2018-06-09')";
			statement.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			relesaeDB(null, statement, connection);
		}
	}

	public void relesaeDB(ResultSet resultSet, Statement statement, Connection connection) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * connection 代表应用程序和数据库的一个连接
	 * 
	 * @throws Exception
	 */
	@Test
	public void TestGetConnection() throws Exception {
		Connection connection = getConnection();
		System.out.println(connection);
	}

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		// 1.准备获取连接的四个字符串
		// 2.获取JDBc 对应的数据流
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		String driverClass = properties.getProperty("dirver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		// 加载数据库驱动程序

		// 2.加载驱动:Class.forName(driverClass)
		Class.forName(driverClass);
		// 3.调用DriverManager.getConnecyion(jdbcUrl,user,password)获取数据连接
		Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
}
