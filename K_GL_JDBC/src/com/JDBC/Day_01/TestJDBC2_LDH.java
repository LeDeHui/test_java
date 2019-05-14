package com.JDBC.Day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

public class TestJDBC2_LDH {
	 
	@Test
	public void testDriver() {
		Connection conn = null;// 创建一个数据库连接
		PreparedStatement ps = null;// 创建预编译语句对象，用这个不用Statement
		ResultSet resultSet = null;// 创建一个结果集对象
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序,不用DriverManager
			String url = "jdbc:oracle:thin:@127.0.0.1:1158:Oracle";// Oracle地址
			String user = "system";// 数据库用户名
			String password = "Ledehui1";// 数据库密码
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			//String sql = "select * from EMP where ename=?";// 预编译语句，“？”代表参数
			String sql = "select  *  from OFFICE_TIME t  where YYYY = ? and  MM=? and DD=?";
			ps = conn.prepareStatement(sql);// 实例化预编译语句
			//ps.setString(1, "SMITH");// 设置参数，前面的1表示第一个问号（第二个问号就用2）
			ps.setString(1, "2019");
			ps.setString(2, "5");
			ps.setString(3, "9");
			resultSet = ps.executeQuery();// 执行查询
			while (resultSet.next()) {// 当结果集不为空时
				//System.out.println(resultSet.getString("MGR"));
				System.out.println(resultSet.getString("TIME_ADD"));
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
