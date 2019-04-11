package Day09;

import org.junit.jupiter.api.Test;

//包装类  8种基本数据类型对应的类。此类即为包装类
//基本数据类型  包装类 String类三者之间的相互装换
public class TestWrapper {
	// 基本数据类型与包装类的转化
	@Test
	public void test1() {
		int i = 10;
		boolean b = true;
		// 基本数据类型--->对应的包装类，调用包装类的构造器
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		Float f = new Float("12.3f");
		System.out.println(f.toString());
		Boolean b1 = new Boolean(b);
		System.out.println(b1);
//		对于boolean，当形参为 true是返回true，其他返回false
		Boolean b3 = new Boolean("trueadas");
		System.out.println(b3);
		
		ojbk o1 = new ojbk();
		System.out.println("$"+o1.b);
		
		//包装类-->对应的基本数据类型
	}
}

class ojbk{
	Boolean b;
}