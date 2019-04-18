package Day11_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*
 * 二 如何处理Exceptional异常 
 * 	Java提供的是异常处理的抓抛模型
 * 	1.“抛”：当我们执行代码是，一但出现异常，就会在异常的代码处，就会生成一个对应的异常类型对象，并将此对象抛出。
 * 		（自动抛出/手动抛出）
 * 		>一但抛出此异常的对象，那么程序就终止执行
 * 		>此异常类的对象抛给方法的调用者
 * 	2.“抓”：抓住上一步抛出来的异常类的对象。
 * 		Java提供了两种方式用来处理一个异常类的对象
 *******处理方式一：
 * 			try{
 * 				//可能出现异常的代码
 * 			}catch(Exception 1 e1 ){
 * 				//处理方式1
 * 			}catch(Exception2 e2 ){
 * 				//处理方式2
 * 			} finally{
 * 				//一定要执行的代码块
 * 			}
 * 		注：1.try内声明的变量，类似与局部变量，出了try｛｝语句，就不能被调用
 * 			2.finally是可选的
 * 			3.catch语句内部是对异常对象的处理；
 * 				>getMessage()     printStackTrace()
 * 			4.可以有多个catch语句，try中抛出的异常类对象从上往下去匹配catch中的异常类型，一但满足就执行catch语句中的代码，执行完就跳出其后的多条catch语句。直到finally
 * 			5.如果异常处理了，其后的代码继续执行
 * 			6.若多个catch中多个异常类型的“并列”关系，孰上孰下都可以
 * 				若多个catch中多个异常类型是“包含”关系，必须将子类放在父类的上面，否则报错
 * 			7.finally中存放的是一定会被执行的代码，不管try中catch中是否仍有异常未处理，以及是否有return语句
 * 			8.try -catch 是可以嵌套的
 *******处理方式二：
 * 
 * 三 对应运行是异常来说，那么不显式的进行处理
 * 		对应编译时异常来说，必须要显式的进行处理
 * 
 * */
public class TestException1 {
	// 编译是异常
	@Test
	public void test6() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("hello.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}

		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e2) {
			System.out.println(e2.getMessage());
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 常见的运行时异常

	// 4.空指针异常 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
//	 		p=null;
		System.out.println(p.toString());
	}

	// 3.类型转换异常 java.lang.ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String string = (String) obj;
		} catch (ClassCastException e1) {
			// TODO: handle exception
			System.out.println("出现类型转换异常");
			// System.out.println(10 / 0);
			System.out.println(e1.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("hello!");
		}
	}

	// 2.算数异常 java.lang.ArithmeticException
	@Test
	public void test3() {
		try {
			int i = 10;
			System.out.println(i / 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// 1.数组下标越界的异常 java.lang.ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		try {
			int[] i = new int[10];
			System.out.println(i[10]);
		} catch (Exception e) {
			System.out.println("出现异常");
		}
	}

	@Test
	// java.util.InputMismatchException
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入");
		try {
			int i = scanner.nextInt();
			System.out.println(i);
		} catch (InputMismatchException e) {
			System.out.println("出现类型不匹配的异常");
		}
	}

}
