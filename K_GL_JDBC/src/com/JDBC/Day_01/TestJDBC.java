package com.JDBC.Day_01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

public class TestJDBC {
	/*
	 * Driver 是一个接口 数据库厂商必须提供实现的接口,能从其中获取数据库连接
	 */
	@Test
	public void testDriver() {
		// 1. 创建一个 Driver 实现类的对象
		/*
		 * Driver driver = new com.mysql.jdbc.Driver();
		 * 
		 * // 2. 准备连接数据库的基本信息: url, user, password String url =
		 * "jdbc:mysql://localhost:3306/test"; Properties info = new Properties();
		 * info.put("user", "root"); info.put("password", "1230");
		 * 
		 * // 3. 调用 Driver 接口的 connect(url, info) 获取数据库连接 Connection connection =
		 * (Connection) driver.connect(url, info); System.out.println(connection);
		 */
	}

	public Connection getConnection() throws Exception {
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		driverClass = properties.getProperty("dirver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Driver driver = (Driver) Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection connection = driver.connect(jdbcUrl, info);
		return connection;
	}

	@Test
	public void testGetConnection() throws Exception {
		System.out.println(getConnection());
	}

}
