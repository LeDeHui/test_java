package Day15_2_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.Test;

public class TestOtherStream {
	/*
	 *	 ��׼����������� ��׼��������� System.out ��׼���������� System.in
	 */
	@Test
	public void test2() {
		/*
		 * 	��Ŀ�� �Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת���ɴ�д��� Ȼ������������������ ֱ�������� e ���� exit �ǣ������˳�
		 */
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while (true) {
				System.out.println("�������ַ�����");
				str = br.readLine();
				if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 	���ʵ���ֽ������ַ���֮���ת�� ת���� InputStreamReader OutputStreamWriter ���룺�ֽ�����-->�ַ���
	 * 	���룺�ַ���-->�ֽ�����
	 */
	@Test
	public void test1() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// ����
			File file = new File("hello.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);

			// ����
			File file1 = new File("hello4.txt");
			FileOutputStream fos = new FileOutputStream(file1);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osw);

			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
}