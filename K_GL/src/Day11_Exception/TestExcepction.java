package Day11_Exception;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * java.lang.Throwable
 * 	|-----Error:���󡣳����в����д���
 * 	|-----Exception���쳣��Ҫ���ڱ�д�����ǣ���Ҫ���ǵ�
 * 		|----����ʱ�쳣���ڱ����ڼ����ֵ��쳣��ִ��javac.exe����ʱ�������쳣��
 * 		|----�������쳣���������ڼ���ֵ��쳣��ִ��java.exe����ʱ�������쳣��
 * */
public class TestExcepction {
	// ����������ʱ�쳣
	// 4.��ָ���쳣 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
//		p=null;
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

	@Test
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������");
		int i = scanner.nextInt();
		System.out.println(i);
	}
}
class Person{
	
}