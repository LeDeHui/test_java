package Day15_2_IO;
/*
 * 1.流的分类
 *	按照数据流向的不同：输入流，输出流
 *	按照处理数据的单位不同：字节流	字符流（处理的文本文件）
 * 	按照角色的不同：节点流（直接作用于文件）	处理了
 *
 * 2.IO 的体系
 * 	抽象基类			节点流（文件流）		缓冲流
 * 	InputStream		FileInputStream		BufferedInputStream
 * 	OutputStream	FileOutputStream	BufferedOutputStream
 * 	Reader			FileReader			BufferedReader
 * 	Writer			FileWriter			BufferedWriter
 * 
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
  *  使用FileReader FileWriter 可以实现文本文件的复制
  *  对应非文本文件（视频文件，音频文件，图片），只能用字节流！
 * 
 * */
public class TestFileReaderWriter {

	@Test
	public void testFileReaderWriter() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			File scr = new File("fg11.txt");
			File desc = new File("fg12.txt");

			fr = new FileReader(scr);
			fw = new FileWriter(desc);

			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				fw.write(c, 0, len);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileReader() {
		FileReader fr = null;
		try {
			File file = new File("fg11.txt");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				String string = new String(c, 0, len);
				System.out.print(string);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}
}
