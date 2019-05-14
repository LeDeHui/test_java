package com.JDBC.Day_01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ����JDBC�Ĺ�����,���з�װ��һЩ���� Version 1.0
 * 
 */
public class JDBCTools {
	public static void release3(ResultSet rs, Statement statement, Connection connection) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	 * �ر�Statement��Connection
	 */

	public static void release(Statement statement, Connection connection) {

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
	 * 1.��ȡ���ӵķ��� ͨ����ȡ�����ļ������ݿ��������ȡһ������
	 * 
	 */
	public static Connection getConnection() throws Exception {

		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		Properties properties = new Properties();

		InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");

		properties.load(is);

		driverClass = properties.getProperty("dirver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		// �������ݿ���������

		Class.forName(driverClass);

		// ͨ��DriverManager��getConnection()������ȡ���ݿ�����
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;

	}

}
