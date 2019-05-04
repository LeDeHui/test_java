package Day16_3_RanDomAccessFile;
/*
 * RanDomAccessFile;֧���������
 * 1.�ȿ��Գ䵱һ��������,�ֿ��Գ䵱һ�������
 * 2.֧�ִ��ļ��Ŀ�ͷ��ȡ,д��
 * 3.֧�ִ�����λ�õĶ�ȡд��(����)
 * 
 * */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

import org.junit.Test;

public class TestRanDomAccessFile {
	// ����,�Ż�
	@Test
	public void test4() {
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
			raf1.seek(3);

			byte[] b = new byte[10];
			int len;
			StringBuffer sb = new StringBuffer();
			while ((len = raf1.read(b)) != -1) {
				sb.append(new String(b, 0, len));
			}
			raf1.seek(3);
			raf1.write("xy".getBytes());
			raf1.write(sb.toString().getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (raf1 != null) {

				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ʵ�ֲ���
	@Test
	public void test3() {
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
			raf1.seek(3);
			String str = raf1.readLine();
			// long l = raf1.getFilePointer();
			raf1.seek(3);
			raf1.write("xy".getBytes());
			raf1.write(str.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (raf1 != null) {

				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ʵ�ֵ�ʵ��ɾ�Ǹ��ǵ�Ч��
	@Test
	public void test2() {
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
			raf1.seek(3);
			raf1.write("xy".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (raf1 != null) {

				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// �����ļ��Ķ�,д
	@Test
	public void test1() {
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {

			raf1 = new RandomAccessFile(new File("hello.txt"), "r");
			raf2 = new RandomAccessFile(new File("hello1.txt"), "rw");
			byte[] b = new byte[20];
			int len;
			while ((len = raf1.read(b)) != 1) {
				raf2.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			if (raf2 != null) {

				try {
					raf2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (raf1 != null) {

				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
