package Day18_3_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/*
 * 与时间相关的类
 * 1.System 类下的currentTimeMillis() ：一般用于计算时间差
 * 2.Date类：java.util.Date 以及其子类  java.sql.Date
 * 		如何创建其实例，及其下的方法：toString() getTime()
 * 3.java.text.SimpleDateFormat类
 * 4.Calendar类
 * 
 * */ 
import java.util.Date;

import org.junit.Test;

public class TestDate {
	//4.Calendar类
	public void test3()  {
		Calendar c = Calendar.getInstance();
		 
		
	}
	
	//3.java.text.SimpleDateFormat类  :易于国际化
	/*	格式化：日期--->文本  使用SimpleDateFormat类里的format()方法
	 * 	解析：    文本-->日期   使用SimpleDateFormat类里的parse()方法
	 * */
	@Test
	public void test2() throws ParseException {
		//1.格式化1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date  = sdf.format(new Date());//19-5-6 上午11:59
		System.out.println(date);
		//2.格式化2
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE,yyyy-MM-dd hh:mm:ss");//2019-05-06 11:59:14
		String date1  = sdf1.format(new Date());//星期二,2019-05-07 01:15:18
		System.out.println(date1);
		//3.解析
		Date date2 = sdf.parse("19-5-6 上午11:42");
		Date date3 = sdf1.parse("星期二,2019-05-07 01:15:18");
		System.out.println(date2);
		System.out.println(date3);
	}
	@Test
	//2.Date类
	public void test1() {
//		java.sql.Date d2 = new java.sql.Date(1557113459511l);
//		System.out.println(d2);
		//创建一个Date的实例
		Date d1 = new Date();
		System.out.println(d1.toString());//Mon May 06 11:27:58 CST 2019
		System.out.println(d1.getTime());//1557113467508
		Date d2 = new Date(1557113467508l);
		System.out.println(d2.toString());
	
	}
}
