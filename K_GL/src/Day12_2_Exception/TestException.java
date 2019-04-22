package Day12_2_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test; 

//异常处理的方式二：在方法声明出，显式抛出该一场对象的类型
//格式：public void method1() throws IOException
/*在此方法的内部出现异常的时候，会抛出一个异常的对象，抛给方法的调用者
 * 异常的对象可以组成向上抛。直到main中 ，向上抛的过程中，  可以用try-catch处理
 * 
 * 
 * Java的异常处理：抓抛模型
 * 1.抓：异常的处理。两种方式（① try-catch-finally   ②throws + 异常类型）
 * 2.抛：一旦执行过程中，出现异常，会抛出一个异常类的对象。（自动的抛出VS手动抛出（throw +异常类的对象））
 * 		>>异常类。既可以是现成的异常类，也可以是自己创建的异常类
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
