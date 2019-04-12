package Day09;

import org.junit.jupiter.api.Test;

//包装类  8种基本数据类型对应的类。此类即为包装类
//基本数据类型  包装类 String类三者之间的相互装换
public class TestWrapper {
	
	//基本数据类型，包装类与String类之间的转换
	@Test
	public void test2() {
		//基本数据类型，包装类-->String类
		//调用STring 类的静态重载valueof（x）方法
		int i1 = 10;
		Integer i2 = i1;
		String str2 = String.valueOf(i2);
		System.out.println(str2);
		boolean b1 = true;
		String str3 = String.valueOf(b1);
		System.out.println(str3);
		
		//String类 --> 基本数据类型，包装类
		//调用包装类的parseXXX（String Str）方法
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		Boolean b2 = Boolean.parseBoolean(str3);
		System.out.println(b2);
		
		
	}
	
	// 基本数据类型与包装类的转化
	@Test
	public void test1() {
		int i = 10;
		boolean b = true;
		// 基本数据类型--->对应的包装类，调用包装类的构造器
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
//		Integer i2=new Integer("123asd");
//		java.lang.NumberFormatException:
//		System.out.println(i2.toString());
		Float f = new Float("12.3f");
		System.out.println(f.toString());
		Boolean b1 = new Boolean(b);
		System.out.println(b1);
//		对于boolean，当形参为 true是返回true，其他返回false
		Boolean b3 = new Boolean("trueadas");
		System.out.println(b3);
//		Boolean可以为null
		ojbk o1 = new ojbk();
		System.out.println("$ " + o1.b);

		// 包装类-->对应的基本数据类型:调用包装类的xxxvalue（）方法
		int i2 = i1.intValue();
		System.out.println(i2);
		float f2 = f.floatValue();
		System.out.println(f2);
		boolean b2 = b3.booleanValue();
		System.out.println(b2);
		// JDK 5.0以后，自动装箱核拆箱
//		int i4 = 12;
//		Integer i3 = i4

		Integer i3 = 12;// 自动装箱
		int i5 = i3;// 自动拆箱
	}
}

class ojbk {
	Boolean b;
}