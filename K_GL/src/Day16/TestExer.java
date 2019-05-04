package Day16;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestExer {
	// ʹ���ַ������ݵ����
	@Test
	public void test2() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test1.txt"));
			String str = "�����Ƿ���̩��Ϊ�������͵ط��ɻ�ط�����\n" + "��ͻȻ�ڹѸ��������ú�ͬʱ������˵�����Ƿǹ���������\n" + "����ͬʱ�ڹ�u�����չ���Aug����ʡ���鰸�¸µظ���u�ɹ�\n"
					+ "���ϸְ��ifs������˹��iucn";
			bw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// ʹ���ֽ������ݵ����
	@Test
	public void test1() {
		BufferedOutputStream bos = null;

		try {
			FileOutputStream fos = new FileOutputStream(new File("test.txt"));
			bos = new BufferedOutputStream(fos);

			String str = "�����Ƿ���̩��Ϊ�������͵ط��ɻ�ط�����" + "��ͻȻ�ڹѸ��������ú�ͬʱ������˵�����Ƿǹ���������" + "����ͬʱ�ڹ�u�����չ���Aug����ʡ���鰸�¸µظ���u�ɹ�"
					+ "���ϸְ��ifs������˹��iucn";
			bos.write(str.getBytes());
			bos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
