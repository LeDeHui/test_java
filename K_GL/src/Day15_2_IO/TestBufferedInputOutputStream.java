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
 * 2.IO ����ϵ
 * 			�������			�ڵ������ļ�����		������(���������ļ��Ĵ���Ч��)
 *	���ı� 	InputStream		FileInputStream		BufferedInputStream
 *	���ı�	OutputStream	FileOutputStream	BufferedOutputStream  (flush())
 * 	�ı� 	Reader			FileReader			BufferedReader(readLine())
 *	�ı�		Writer			FileWriter			BufferedWriter (flush())
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
				// bw.write(str + "\n"); //����
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

	// ʹ��BufferedInputStream��BufferedOutputStream ʵ���ı��ļ��ĸ���
	@Test
	public void testBufferedInputStream() {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			// 1. �ṩ���룬д�����ļ�
			File file1 = new File("hj.jpg");
			File file2 = new File("hj2.jpg");
			// 2.�ȴ�������ڵĽڵ�����FileInputStream FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			// 3.�������Ľڵ����Ķ�����Ϊ�βδ��ݸ��������Ĺ�������
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			// 4.�����ʵ���ļ����ƵĲ���
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();// ˢ��
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.�ر���Ӧ����
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
