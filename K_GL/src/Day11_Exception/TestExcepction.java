package Day11_Exception;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * java.lang.Throwable
 * 	|-----Error:错误。程序中不进行处理
 * 	|-----Exception：异常：要求在编写程序是，就要考虑到
 * 		|----编译时异常：在编译期间会出现的异常（执行javac.exe命令时，出现异常）
 * 		|----运行是异常：在运行期间出现的异常（执行java.exe命令时，出现异常）
 * */
public class TestExcepction {
	// 常见的运行时异常
	// 4.空指针异常 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
//		p=null;
		System.out.println(p.toString());
	}

	// 3.类型转换异常 java.lang.ClassCastException
	@Test
	public void test4() {
		Object obj = new Date();
//		String string =(String ) obj;
	}

	// 2.算数异常 java.lang.ArithmeticException
	@Test
	public void test3() {
		int i = 10;
//		System.out.println(i / 0);
	}

	// 1.数组下标越界的异常 java.lang.ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		int[] i = new int[10];
//		System.out.println(i[10]);
	}

	@Test
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入");
		int i = scanner.nextInt();
		System.out.println(i);
	}
}
class Person{
	
}