package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
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
