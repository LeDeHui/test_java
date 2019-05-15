package com.atguigu.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class TestJDBC2_LDH {
	 
	@Test
	public void testDriver() {
		Connection conn = null;// ����һ�����ݿ�����
		PreparedStatement ps = null;// ����Ԥ�������������������Statement
		ResultSet resultSet = null;// ����һ�����������
		try {
			
			Properties properties = new Properties();
			//2.��ȡJDBc ��Ӧ��������
			InputStream is = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(is);
			String driverClass = properties.getProperty("dirver");
			String url = properties.getProperty("jdbcUrl");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			
			/*			 
			//ԭ����
			Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������,����DriverManager
			String url = "jdbc:oracle:thin:@127.0.0.1:1158:Oracle";// Oracle��ַ
			String user = "system";// ���ݿ��û���
			String password = "Ledehui1";// ���ݿ�����
			*/
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
			//String sql = "select * from EMP where ename=?";// Ԥ������䣬�������������
			String sql = "select  *  from OFFICE_TIME t  where YYYY = ? and  MM=?  ";
//			String sql = "select  *  from emp  where empno = ?   ";
			ps = conn.prepareStatement(sql);// ʵ����Ԥ�������
			//ps.setString(1, "SMITH");// ���ò�����ǰ���1��ʾ��һ���ʺţ��ڶ����ʺž���2��
			ps.setString(1, "2019");
			ps.setString(2, "5"); 
//			ps.setString(1, "7369");
			resultSet = ps.executeQuery();// ִ�в�ѯ
			while (resultSet.next()) {// ���������Ϊ��ʱ
				 System.out.println(  resultSet.getString("TIME_ADD") + "---"+resultSet.getString("TIME_CD"));
//				 System.out.println(resultSet.getString("MGR"));
//			System.out.println( resultSet.getString("ename") );
//			System.out.println(resultSet.getInt(1)); 
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ��С�����ͷ�. resultSet < Statement < Connection
			// �ͷ�ʱ����close��������. �������һ������Ĺر� �������쳣. ҲҪ��֤�����Ķ���رշ���������.
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
