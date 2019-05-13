package com.JDBC.Day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

public class TestJDBC2_LDH {
	/*
	 * Driver 是一个接口 数据库厂商必须提供实现的接口,能从其中获取数据库连接
	 * 
	 * 
	 * 1.加入驱动
	 * 
	 */
	@Test
	public void testDriver() {
		Connection conn = null;// 创建一个数据库连接
		PreparedStatement ps = null;// 创建预编译语句对象，用这个不用Statement
		ResultSet resultSet = null;// 创建一个结果集对象
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序,不用DriverManager
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:Oracle";// Oracle地址
			String user = "scott";// 数据库用户名
			String password = "tiger";// 数据库密码
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			String sql = "select * from EMP where ename=?";// 预编译语句，“？”代表参数
			ps = conn.prepareStatement(sql);// 实例化预编译语句
			ps.setString(1, "SMITH");// 设置参数，前面的1表示第一个问号（第二个问号就用2）
			resultSet = ps.executeQuery();// 执行查询
			while (resultSet.next()) {// 当结果集不为空时
				System.out.println(resultSet.getString("MGR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 从小到大释放. resultSet < Statement < Connection
			// 释放时调用close方法即可. 如果其中一个对象的关闭 出现了异常. 也要保证其他的对象关闭方法被调用.
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
