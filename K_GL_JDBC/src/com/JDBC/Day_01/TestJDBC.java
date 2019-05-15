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
	/**
	 * ResultSet:�����,��װ��ʹ��JDBC������ѯ�Ľ��
	 * 1.����Statement ����� executeQuery(SQL)���Եõ����صĽ����
	 * 2.ResultSet ���ص�ʵ���Ͼ���һ�����ݱ�,��һ��ָ�������ݱ�ĵ�һ��ǰ��.
	 * 	���Ե���next()���������һ���Ƿ���Ч,����Ч����true,��ָ������.
	 * 	�൱�� Iterator �� hasNext() ��next()�����Ľ����
	 * 3.��ָ�붨λ��һ����,����ͨ������getXXX(index)�����XXX(columnName)
	 * 		��ȡÿһ�е�ֵ.  ����:getInt(1) getString("name")
	 * 4.ResultSet��ȻҲ��Ҫ���йر�
	 * 
	 * 
	 * */
	@Test
	public void testResultSet() {
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			//1. ��ȡ Connection
			conn = JDBCTools.getConnection();
			System.out.println(conn);
			
			//2. ��ȡ Statement
			statement = conn.createStatement();
			System.out.println(statement);
			
			//3. ׼�� SQL
			String sql = "SELECT id, name, email, birthday " +
					"FROM table_test where id =1 ";
			
			//4. ִ�в�ѯ, �õ� ResultSet
			rs = statement.executeQuery(sql);
			System.out.println(rs);
			
			//5. ���� ResultSet
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString(3);
				Date birth = rs.getDate(4);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCTools.release3(rs,statement, conn);
		}
		
		
	}

	/*
	 *	 ͨ�õĸ��µķ���:����insert update delete
	 */
	@Test
	public void update(String sql) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			JDBCTools.release(statement, connection);
//			if (statement!=null) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (connection!=null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}

	}

	/**
	 * ͨ��JDBC��ָ�������ݱ��в���һ������. 1.Statement:����ִ��SQL���Ķ���
	 * 1)ͨ��Connection��creaStatement()��������ȡ 2)ͨ��executeUpdate(sql)��ִ��SQL���.
	 * 3)�����SQL����˵insert update ��delete,���ǲ���select
	 * 2.Connection,Statement����Ӧ�ó�������ݷ�������������Դ,ʹ�ú�һ��Ҫ�ر� ��Ҫ��finallyһ��ִ��
	 * 3.�رյ�˳��:�ȹغ��ȡ��Statement,��ر�Connection
	 *
	 *
	 */
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.��ȡ���ݿ�
			conn = getConnection2();
			// 3.׼��SQL���
			String sql = "insert into TABLE_TEST(id,name,email,BIRTHDAY) values(13,'le','ledehui@163.com','1992-05-17')";
			// 4.ִ�в���
			// 4.1)��ȡ����SQL����Statement����,����Connection ��createStatem()��������ȡ
			statement = conn.createStatement();
			// 4.2)����Statement�����executeUpdate(sql)ִ��sql�����в���
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر�Statement����
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 2.�ر�����
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testGetConnection2() throws Exception {
		System.out.println(getConnection2());
	}

	public Connection getConnection2() throws Exception {
		// 1.׼���������ݿ��4���ַ�
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		// ����Properties����
		Properties properties = new Properties();
		// 2.��ȡJDBc ��Ӧ��������
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
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

	/**
	 * DriverManager �������Ĺ����� 1.����ͨ�����ص�getConnection()������ȡ���ݿ�����.��Ϊ����
	 * 2.����ͬʱ��������������:��ע���˶�����ݿ�����,�����getConnection()�����Ǵ���Ĳ�����ͬ,�����ز�ͬ���ݿ������
	 */
	@Test
	public void testDriverManager() throws Exception {
		// 1.�������ݿ��4���ַ���
		String driverClass = null;// ������ȫ����
		String jdbcUrl = null;// JDBCURL
		String user = null;
		String password = null;

		// ��ȡ�����ļ�
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		driverClass = properties.getProperty("dirver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// �������ݿ���������(��Ӧ�� Driver ʵ�������� ע�������ľ�̬�����)
//		DriverManager.registerDriver(Class.forName(driverClass).newInstance());
		Class.forName(driverClass);
		// ͨ��DriverManager��getConnection()������ȡ���ݿ�����
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection);
	}

	/*
	 * Driver ��һ���ӿ� ���ݿ⳧�̱����ṩʵ�ֵĽӿ�,�ܴ����л�ȡ���ݿ�����
	 */
	@Test
	public void testDriver() {
		// 1. ����һ�� Driver ʵ����Ķ���
		/*
		 * Driver driver = new com.mysql.jdbc.Driver();
		 * 
		 * // 2. ׼���������ݿ�Ļ�����Ϣ: url, user, password String url =
		 * "jdbc:mysql://localhost:3306/test"; Properties info = new Properties();
		 * info.put("user", "root"); info.put("password", "1230");
		 * 
		 * // 3. ���� Driver �ӿڵ� connect(url, info) ��ȡ���ݿ����� Connection connection =
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
