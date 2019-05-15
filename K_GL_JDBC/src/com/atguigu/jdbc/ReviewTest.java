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
	 * 1.ResultSet ��װJDBC�Ĳ�ѯ���
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
	 * 1.Statement ������SQL�Ķ���
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
	 * connection ����Ӧ�ó�������ݿ��һ������
	 * 
	 * @throws Exception
	 */
	@Test
	public void TestGetConnection() throws Exception {
		Connection connection = getConnection();
		System.out.println(connection);
	}

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
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
