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
 * �� ��δ���Exceptional�쳣 
 * 	Java�ṩ�����쳣�����ץ��ģ��
 * 	1.���ס���������ִ�д����ǣ�һ�������쳣���ͻ����쳣�Ĵ��봦���ͻ�����һ����Ӧ���쳣���Ͷ��󣬲����˶����׳���
 * 		���Զ��׳�/�ֶ��׳���
 * 		>һ���׳����쳣�Ķ�����ô�������ִֹ��
 * 		>���쳣��Ķ����׸������ĵ�����
 * 	2.��ץ����ץס��һ���׳������쳣��Ķ���
 * 		Java�ṩ�����ַ�ʽ��������һ���쳣��Ķ���
 *******����ʽһ��
 * 			try{
 * 				//���ܳ����쳣�Ĵ���
 * 			}catch(Exception 1 e1 ){
 * 				//����ʽ1
 * 			}catch(Exception2 e2 ){
 * 				//����ʽ2
 * 			} finally{
 * 				//һ��Ҫִ�еĴ����
 * 			}
 * 		ע��1.try�������ı�����������ֲ�����������try������䣬�Ͳ��ܱ�����
 * 			2.finally�ǿ�ѡ��
 * 			3.catch����ڲ��Ƕ��쳣����Ĵ���
 * 				>getMessage()     printStackTrace()
 * 			4.�����ж��catch��䣬try���׳����쳣������������ȥƥ��catch�е��쳣���ͣ�һ�������ִ��catch����еĴ��룬ִ������������Ķ���catch��䡣ֱ��finally
 * 			5.����쳣�����ˣ����Ĵ������ִ��
 * 			6.�����catch�ж���쳣���͵ġ����С���ϵ���������¶�����
 * 				�����catch�ж���쳣�����ǡ���������ϵ�����뽫������ڸ�������棬���򱨴�
 * 			7.finally�д�ŵ���һ���ᱻִ�еĴ��룬����try��catch���Ƿ������쳣δ�����Լ��Ƿ���return���
 * 			8.try -catch �ǿ���Ƕ�׵�
 *******����ʽ����
 * 
 * �� ��Ӧ�������쳣��˵����ô����ʽ�Ľ��д���
 * 		��Ӧ����ʱ�쳣��˵������Ҫ��ʽ�Ľ��д���
 * 
 * */
public class TestException1 {
	// �������쳣
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

	// ����������ʱ�쳣

	// 4.��ָ���쳣 java.lang.NullPointerException
	@Test
	public void test5() {
		Person p = new Person();
//	 		p=null;
		System.out.println(p.toString());
	}

	// 3.����ת���쳣 java.lang.ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String string = (String) obj;
		} catch (ClassCastException e1) {
			// TODO: handle exception
			System.out.println("��������ת���쳣");
			// System.out.println(10 / 0);
			System.out.println(e1.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("hello!");
		}
	}

	// 2.�����쳣 java.lang.ArithmeticException
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

	// 1.�����±�Խ����쳣 java.lang.ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		try {
			int[] i = new int[10];
			System.out.println(i[10]);
		} catch (Exception e) {
			System.out.println("�����쳣");
		}
	}

	@Test
	// java.util.InputMismatchException
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������");
		try {
			int i = scanner.nextInt();
			System.out.println(i);
		} catch (InputMismatchException e) {
			System.out.println("�������Ͳ�ƥ����쳣");
		}
	}

}
