package Day15_2_IO;
/*
 * 1.���ķ���
 *	������������Ĳ�ͬ���������������
 *	���մ������ݵĵ�λ��ͬ���ֽ���	�ַ�����������ı��ļ���
 * 	���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ���	������
 *
* 2.IO ����ϵ
 * 			�������			�ڵ������ļ�����		������
 *	���ı� 	InputStream		FileInputStream		BufferedInputStream
 *	���ı�	OutputStream	FileOutputStream	BufferedOutputStream
 * 	�ı� 	Reader			FileReader			BufferedReader
 *	�ı�		Writer			FileWriter			BufferedWriter
 * 
 * 
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInOutputStream {
	
	@Test
	public void TestcopyFile() {
		String src = "hello.txt";
		String desc  = "11.txt";
		copyFile(src, desc);
		
	}
	//ʵ���ļ����Ƶķ���
	public static void  copyFile(String src ,String desc) {
		// 1. �ṩ���룬д�����ļ�
				File file1 = new File(src);
				File file2 = new File(desc);
				// 2.�ṩ��Ӧ����
				FileInputStream fis = null;
				FileOutputStream fos = null;
				try {
					fis = new FileInputStream(file1);
					fos = new FileOutputStream(file2);
					// 3.ʵ���ļ��ĸ���
					byte[] b = new byte[5];// ��ȡ
					int len;// ÿ�ζ��볤��
					while ((len = fis.read(b)) != -1) {
						fos.write(b, 0, len);
						// fos.write(new String(b, 0, len).getBytes());
					}

				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					if (fos != null) {
						try {
							fos.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					if (fis != null) {
						try {
							fos.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}

	}
	
	
	@Test
	public void TestFileOutputStream2() {
		// 1. �ṩ���룬д�����ļ�
		File file1 = new File("C:\\Users\\ledehui.FSTVOFFICE\\Desktop\\hj.jpg");
		File file2 = new File("C:\\Users\\ledehui.FSTVOFFICE\\Desktop\\hj1.jpg");
		// 2.�ṩ��Ӧ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.ʵ���ļ��ĸ���
			byte[] b = new byte[5];// ��ȡ
			int len;// ÿ�ζ��볤��
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
				// fos.write(new String(b, 0, len).getBytes());
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (fis != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}
	
	//��Ӳ�̶�ȡһ���ļ�����д�뵽��һ��λ�ã��൱���ļ����ƣ�
	@Test
	public void TestFileOutputStream1() {
		// 1. �ṩ���룬д�����ļ�
		File file1 = new File("hello.txt");
		File file2 = new File("hello3.txt");
		// 2.�ṩ��Ӧ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.ʵ���ļ��ĸ���
			byte[] b = new byte[5];// ��ȡ
			int len;// ÿ�ζ��볤��
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
				// fos.write(new String(b, 0, len).getBytes());
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (fis != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

	// FileoutputStream ���
	@Test
	public void testFileOutputStream1() {
		// 1.����һ��File���󣬱���д����ļ�λ�á�
		// ����������ļ����Բ����ڡ�
		// ��ִ�й����У��粻���ڣ����Զ�����������ڣ��Ὣԭ�е��ļ����Ǳ���
		File file = new File("hello2.txt");
		FileOutputStream fos = null;
		// 2.����һ��FileOutputStream�Ķ��󣬽�file������Ϊ�βδ��ݸ�FileOutputStream��������
		try {
			fos = new FileOutputStream(file);
			// 3.д��Ĳ���
			fos.write(new String("I Love China I Love the World").getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 4.�ر������
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testFileInputStream3() {
		File file = new File("hello.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[5];// ��ȡ��������Ҫд�������
			int len;// ÿ�ζ��뵽byte���ֽڵĳ���
			while ((len = fis.read(b)) != -1) {
//				for (int i = 0; i < len; i++) {
//					System.out.print((char) b[i]);
//				}
				String str = new String(b, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// ʹ��try-catch�ķ�ʽ���������쳣��������֤���Ĺر�һ������ִ��
	@Test
	public void testFileInputStream2() {
		// 2.����һ��FileInputStream��Ķ���
		FileInputStream fis = null;
		try {
			// 1.����һ��File��Ķ���
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			// 3.����FileInputStream�ķ�����ʵ��File�ļ��Ķ�ȡ
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4.�ر���Ӧ����
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ��Ӳ�̴��ڵ�һ���ļ��У���ȡ�����ݵ������У�ʹ��FileInputStream
	// Ҫ��ȡ���ļ�һ��Ҫ���ڣ�������FileNotFoundException
	@Test
	public void testFileInputStream1() throws Exception {
		// 1.����һ��File��Ķ���
		File file = new File("hello.txt");
		// 2.����һ��FileInputStream��Ķ���
		FileInputStream fis = new FileInputStream(file);
		// 3.����FileInputStream�ķ�����ʵ��File�ļ��Ķ�ȡ
		/*
		 * read():��ȡ�ļ���һ���ֽڡ���ִ�е��ļ���βʱ������-1
		 */
		/*
		 * int b = fis.read(); while (b != -1) { // System.out.println(b);
		 * System.out.println((char)b); b = fis.read(); }
		 */
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
//		System.out.println(b);
		// 4.�ر���Ӧ����
		fis.close();
	}

}
