package Day15_2_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 2.IO 的体系
 * 			抽象基类			节点流（文件流）			缓冲流(可以提升文件的处理效率)
 *	非文本 	InputStream		FileInputStream		BufferedInputStream
 *	非文本	OutputStream	FileOutputStream	BufferedOutputStream  (flush())
 * 	文本 		Reader			FileReader			BufferedReader(readLine())
 *	文本		Writer			FileWriter			BufferedWriter (flush())
 * */

public class TestBufferedInputOutputStream {

	@Test
	public void testBufferedRead() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file1 = new File("fg11.txt");
			File file2 = new File("fg13.txt");

			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			String str = null;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				// bw.write(str + "\n"); //或者
				bw.flush();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 使用BufferedInputStream和BufferedOutputStream 实现文本文件的复制
	@Test
	public void testBufferedInputStream() {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		BufferedInputStream bis1 = null;
		try {
			// 1. 提供读入，写出的文件
			File file1 = new File("hj.jpg");
			File file2 = new File("hj2.jpg");
			// 2.先创建相对于的节点流：FileInputStream FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			// 3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			bis1= new BufferedInputStream(new FileInputStream(new File("hj.jpg")));
			// 4.具体的实现文件复制的操作
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();// 刷新
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭相应的流
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
					bis1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
