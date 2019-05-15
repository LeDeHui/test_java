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
	 * 1.Statement 是用于SQL的对象
	 * 
	 * */
	public void TestStement() {
		Connection connection = null;
		Statement statement = null;
	}
	public void   relesaeDB(ResultSet rSet ) {
		// TODO Auto-generated method stub

	}

	/**
	 * connection 代表应用程序和数据库的一个连接
	 * @throws Exception
	 */
	@Test
	public void TestGetConnection() throws Exception {
		Connection connection = getConnection();
		System.out.println(connection);
	}

	private Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
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
