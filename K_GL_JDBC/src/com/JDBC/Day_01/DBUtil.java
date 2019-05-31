package com.JDBC.Day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC����Oracle���ݿ��ʾ������
 * @author��yanyunfan
 * */

public class DBUtil{
	 
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();// ����Oracle��������
			System.out.println("oracle������������У�");
		}
		catch(InstantiationException e1)
		{
			System.out.println("ʵ���쳣");
		}
		catch(IllegalAccessException e2)
		{
			System.out.println("�����쳣");
		}
		catch(ClassNotFoundException e3)
		{
			System.out.println("MySQL�������Ҳ���");
		}
	}
	
	/***
	 * ����һ�����ݿ�����
	 */ 	
	public static Connection getConnection()
	{
	    Connection connection = null;// ����һ�����ݿ�����
	    try
	    {
	        System.out.println("��ʼ�����������ݿ⣡");
	        String url = "jdbc:oracle:thin:@127.0.0.1:1158:Oracle";//Oracle��Ĭ�����ݿ���
	        String user = "system";// ϵͳĬ�ϵ��û���
	        String password = "Ledehui1";// ��װʱ���õ�����
	        connection = DriverManager.getConnection(url, user, password);// ��ȡ����
	        System.out.println(url);
	        System.out.println("�û�����"+user+"\t"+"���룺******");
	        System.out.println("���ݿ����ӳɹ���");
	        return connection;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	}
}