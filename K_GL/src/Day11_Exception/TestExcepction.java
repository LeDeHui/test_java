package Day11_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/* һ �쳣����ϵ�ṹ
 * java.lang.Throwable
 * 	|-----Error:���󡣳����в����д���
 * 	|-----Exception���쳣��Ҫ���ڱ�д�����ǣ���Ҫ���ǵ�
 * 		|----����ʱ�쳣���ڱ����ڼ����ֵ��쳣��ִ��javac.exe����ʱ�������쳣��
 * 		|----�������쳣���������ڼ���ֵ��쳣��ִ��java.exe����ʱ�������쳣��
 * 
 * ��ִ��һ�������ǣ���������쳣����ô�쳣֮��Ĵ���Ͳ���ִ��
 * 
 * 
 * */

public class TestExcepction {
	// �������쳣
	@Test
	public void test6() throws Exception{
		 
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		fis.close();
	}

	// ����������ʱ�쳣
	/*
	 * Bank bank= new Bank������ Customer[] customer = new Customer[5] ---customer[0] =
	 * new Customer(); System.out.println(customer[0].getFirstName())
	 */
	// 4.��ָ���쳣 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
// 		p=null;
		System.out.println(p.toString());
	}

	// 3.����ת���쳣 java.lang.ClassCastException
	@Test
	public void test4() {
		Object obj = new Date();
//		String string =(String ) obj;
	}

	// 2.�����쳣 java.lang.ArithmeticException
	@Test
	public void test3() {
		int i = 10;
//		System.out.println(i / 0);
	}

	// 1.�����±�Խ����쳣 java.lang.ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		int[] i = new int[10];
//		System.out.println(i[10]);
	}
//java.util.InputMismatchException
	@Test
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������");
		int i = scanner.nextInt();
		System.out.println(i);
	}
}

class Person {

}