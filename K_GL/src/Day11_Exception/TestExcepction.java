package Day11_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/* 一 异常的体系结构
 * java.lang.Throwable
 * 	|-----Error:错误。程序中不进行处理
 * 	|-----Exception：异常：要求在编写程序是，就要考虑到
 * 		|----编译时异常：在编译期间会出现的异常（执行javac.exe命令时，出现异常）
 * 		|----运行是异常：在运行期间出现的异常（执行java.exe命令时，出现异常）
 * 
 * 当执行一个程序是，如果出现异常，那么异常之后的代码就不再执行
 * 
 * 
 * */
public class TestExcepction {
	// 编译是异常
	@Test
	public void test6() throws Exception{
		
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		fis.close();
	}

	// 常见的运行时异常
	/*
	 * Bank bank= new Bank（）； Customer[] customer = new Customer[5] ---customer[0] =
	 * new Customer(); System.out.println(customer[0].getFirstName())
	 */
	// 4.空指针异常 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
// 		p=null;
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
//java.util.InputMismatchException
	@Test
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入");
		int i = scanner.nextInt();
		System.out.println(i);
	}
}

class Person {

}