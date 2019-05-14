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
	 * ResultSet:结果集,封装了使用JDBC经常查询的结果
	 * 1.调用Statement 对象的 executeQuery(SQL)可以得到返回的结果集
	 * 2.ResultSet 返回的实际上就是一张数据表,有一个指针向数据表的第一的前面.
	 * 	可以调用next()方法检测下一行是否有效,若有效返回true,且指针下移.
	 * 	相当于 Iterator 的 hasNext() 和next()方法的结合体
	 * 3.当指针定位到一行是,可以通过调用getXXX(index)或个体XXX(columnName)
	 * 		获取每一列的值.  例如:getInt(1) getString("name")
	 * 4.ResultSet当然也需要进行关闭
	 * 
	 * 
	 * */
	@Test
	public void testResultSet() {
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			//1. 获取 Connection
			conn = JDBCTools.getConnection();
			System.out.println(conn);
			
			//2. 获取 Statement
			statement = conn.createStatement();
			System.out.println(statement);
			
			//3. 准备 SQL
			String sql = "SELECT id, name, email, birthday " +
					"FROM table_test where id =1 ";
			
			//4. 执行查询, 得到 ResultSet
			rs = statement.executeQuery(sql);
			System.out.println(rs);
			
			//5. 处理 ResultSet
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
	 *	 通用的更新的方法:包括insert update delete
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
	 * 通过JDBC向指定的数据表中插入一条数据. 1.Statement:用于执行SQL语句的对象
	 * 1)通过Connection的creaStatement()方法来获取 2)通过executeUpdate(sql)可执行SQL语句.
	 * 3)传入的SQL可以说insert update 或delete,但是不能select
	 * 2.Connection,Statement都是应用程序和数据服务器的连接资源,使用后一定要关闭 需要在finally一定执行
	 * 3.关闭的顺序:先关后获取的Statement,后关闭Connection
	 *
	 *
	 */
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.获取数据库
			conn = getConnection2();
			// 3.准备SQL语句
			String sql = "insert into TABLE_TEST(id,name,email,BIRTHDAY) values(3,'le','ledehui@163.com','1992-05-17')";
			// 4.执行插入
			// 4.1)获取操作SQL语句的Statement对象,调用Connection 的createStatem()方法来获取
			statement = conn.createStatement();
			// 4.2)调用Statement对象的executeUpdate(sql)执行sql语句进行插入
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭Statement对象
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 2.关闭连接
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
		// 1.准备连接数据库的4个字符
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		// 创建Properties对象
		Properties properties = new Properties();
		// 2.获取JDBc 对应的数据流
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
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

	/**
	 * DriverManager 是驱动的管理类 1.可以通过重载的getConnection()方法获取数据库连接.较为方便
	 * 2.可以同时管理多个驱动程序:若注册了多个数据库连接,则调用getConnection()方法是传入的参数不同,即返回不同数据库的链接
	 */
	@Test
	public void testDriverManager() throws Exception {
		// 1.连接数据库的4个字符串
		String driverClass = null;// 驱动的全类名
		String jdbcUrl = null;// JDBCURL
		String user = null;
		String password = null;

		// 读取配置文件
		InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		driverClass = properties.getProperty("dirver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// 加载数据库驱动程序(对应的 Driver 实现类中有 注册驱动的静态代码块)
//		DriverManager.registerDriver(Class.forName(driverClass).newInstance());
		Class.forName(driverClass);
		// 通过DriverManager的getConnection()方法获取数据库连接
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection);
	}

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
