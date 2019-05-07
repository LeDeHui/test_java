package Day18_3_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/*
 * ��ʱ����ص���
 * 1.System ���µ�currentTimeMillis() ��һ�����ڼ���ʱ���
 * 2.Date�ࣺjava.util.Date �Լ�������  java.sql.Date
 * 		��δ�����ʵ���������µķ�����toString() getTime()
 * 3.java.text.SimpleDateFormat��
 * 4.Calendar��
 * 
 * */ 
import java.util.Date;

import org.junit.Test;

public class TestDate {
	//4.Calendar��
	public void test3()  {
		Calendar c = Calendar.getInstance();
		 
		
	}
	
	//3.java.text.SimpleDateFormat��  :���ڹ��ʻ�
	/*	��ʽ��������--->�ı�  ʹ��SimpleDateFormat�����format()����
	 * 	������    �ı�-->����   ʹ��SimpleDateFormat�����parse()����
	 * */
	@Test
	public void test2() throws ParseException {
		//1.��ʽ��1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date  = sdf.format(new Date());//19-5-6 ����11:59
		System.out.println(date);
		//2.��ʽ��2
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE,yyyy-MM-dd hh:mm:ss");//2019-05-06 11:59:14
		String date1  = sdf1.format(new Date());//���ڶ�,2019-05-07 01:15:18
		System.out.println(date1);
		//3.����
		Date date2 = sdf.parse("19-5-6 ����11:42");
		Date date3 = sdf1.parse("���ڶ�,2019-05-07 01:15:18");
		System.out.println(date2);
		System.out.println(date3);
	}
	@Test
	//2.Date��
	public void test1() {
//		java.sql.Date d2 = new java.sql.Date(1557113459511l);
//		System.out.println(d2);
		//����һ��Date��ʵ��
		Date d1 = new Date();
		System.out.println(d1.toString());//Mon May 06 11:27:58 CST 2019
		System.out.println(d1.getTime());//1557113467508
		Date d2 = new Date(1557113467508l);
		System.out.println(d2.toString());
	
	}
}
