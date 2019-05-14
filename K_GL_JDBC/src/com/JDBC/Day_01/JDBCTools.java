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
 * 操作JDBC的工具类,其中封装了一些方法 Version 1.0
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
	 * 关闭Statement和Connection
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
	 * 1.获取连接的方法 通过读取配置文件从数据库服务器获取一个连接
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
		// 加载数据库驱动程序

		Class.forName(driverClass);

		// 通过DriverManager的getConnection()方法获取数据库连接
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;

	}

}
