package Day12_2_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test; 

//�쳣����ķ�ʽ�����ڷ�������������ʽ�׳���һ�����������
//��ʽ��public void method1() throws IOException
/*�ڴ˷������ڲ������쳣��ʱ�򣬻��׳�һ���쳣�Ķ����׸������ĵ�����
 * �쳣�Ķ��������������ס�ֱ��main�� �������׵Ĺ����У�  ������try-catch����
 * 
 * 
 * Java���쳣����ץ��ģ��
 * 1.ץ���쳣�Ĵ������ַ�ʽ���� try-catch-finally   ��throws + �쳣���ͣ�
 * 2.�ף�һ��ִ�й����У������쳣�����׳�һ���쳣��Ķ��󡣣��Զ����׳�VS�ֶ��׳���throw +�쳣��Ķ��󣩣�
 * 		>>�쳣�ࡣ�ȿ������ֳɵ��쳣�࣬Ҳ�������Լ��������쳣��
 * 	
 * */
public class TestException {
	public static void main(String[] args) throws Exception {
		TestException  t1 = new TestException();
		 
			t1.method1();
			System.out.println("123");
	 
	}
	@Test
	public void method1() throws IOException  {
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		fis.close();
	}
}
