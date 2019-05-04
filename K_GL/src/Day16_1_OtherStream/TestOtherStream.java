package Day16_1_OtherStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestOtherStream {
	//对象流:
	
	
	//数据流:用来处理基本数据类型,String,字节组的数据
	//DateInputStream   DateOutputStream
	
	
	
	//打印流:  字节流:printStream  字符流:rintWriter
	@Test
	public void test1() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("print.txt"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建打印流
		PrintStream ps = new PrintStream(fos, true);
		if (ps!=null ) {
			System.setOut(ps);
		}
		for (int i = 0;i< 255;i++) {
			System.out.print((char)i);
			if (i%50 == 0 ) {
				System.out.println();
			}
		}
		
	}

}
