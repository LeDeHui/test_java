package Day12_2_Exception;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test; 

//异常处理的方式二：在方法声明出，显式抛出该一场对象的类型
public class TestException {
	public static void main(String[] args) throws Exception {
		TestException  t1 = new TestException();
		 
			t1.method1();
			System.out.println("123");
	 
	}
	@Test
	public void method1() throws Exception {
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		fis.close();
	}
}
