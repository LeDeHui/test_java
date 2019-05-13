package com.JDBC.Day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

public class TestJDBC2_LDH {
	/*
	 * Driver ��һ���ӿ� ���ݿ⳧�̱����ṩʵ�ֵĽӿ�,�ܴ����л�ȡ���ݿ�����
	 * 
	 * 
	 * 1.��������
	 * 
	 */
	@Test
	public void testDriver() {
		Connection conn = null;// ����һ�����ݿ�����
		PreparedStatement ps = null;// ����Ԥ�������������������Statement
		ResultSet resultSet = null;// ����һ�����������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������,����DriverManager
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:Oracle";// Oracle��ַ
			String user = "scott";// ���ݿ��û���
			String password = "tiger";// ���ݿ�����
			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
			String sql = "select * from EMP where ename=?";// Ԥ������䣬�������������
			ps = conn.prepareStatement(sql);// ʵ����Ԥ�������
			ps.setString(1, "SMITH");// ���ò�����ǰ���1��ʾ��һ���ʺţ��ڶ����ʺž���2��
			resultSet = ps.executeQuery();// ִ�в�ѯ
			while (resultSet.next()) {// ���������Ϊ��ʱ
				System.out.println(resultSet.getString("MGR"));
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
