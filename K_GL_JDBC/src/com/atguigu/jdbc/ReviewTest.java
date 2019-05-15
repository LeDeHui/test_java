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
	 * 1.Statement ������SQL�Ķ���
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
	 * connection ����Ӧ�ó�������ݿ��һ������
	 * @throws Exception
	 */
	@Test
	public void TestGetConnection() throws Exception {
		Connection connection = getConnection();
		System.out.println(connection);
	}

	private Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		// 1.׼����ȡ���ӵ��ĸ��ַ���
		// 2.��ȡJDBc ��Ӧ��������
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		String driverClass = properties.getProperty("dirver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		// �������ݿ���������
		
		// 2.��������:Class.forName(driverClass)
		Class.forName(driverClass);
		// 3.����DriverManager.getConnecyion(jdbcUrl,user,password)��ȡ��������
		Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
}
