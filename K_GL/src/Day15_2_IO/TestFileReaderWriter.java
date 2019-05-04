package Day15_2_IO;
/*
 * 1.���ķ���
 *	������������Ĳ�ͬ���������������
 *	���մ������ݵĵ�λ��ͬ���ֽ���	�ַ�����������ı��ļ���
 * 	���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ���	������
 *
 * 2.IO ����ϵ
 * 	�������			�ڵ������ļ�����		������
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
  *  	ʹ��FileReader FileWriter ����ʵ���ı��ļ��ĸ���
  *  	��Ӧ���ı��ļ�����Ƶ�ļ�����Ƶ�ļ���ͼƬ����ֻ�����ֽ�����
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
