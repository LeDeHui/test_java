package Day15_2_IO;
/*
 * 1.流的分类
 *	按照数据流向的不同：输入流，输出流
 *	按照处理数据的单位不同：字节流	字符流（处理的文本文件）
 * 	按照角色的不同：节点流（直接作用于文件）	处理了
 *
 * 2.IO 的体系
 * 	抽象基类			节点流（文件流）
 * 	InputStream		FileInputStream
 * 	OutputStream	FileOutputStream
 * 	Reader			FileReader
 * 	Writer			FileWriter
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
	//实现文件复制的方法
	public static void  copyFile(String src ,String desc) {
		// 1. 提供读入，写出的文件
				File file1 = new File(src);
				File file2 = new File(desc);
				// 2.提供相应的流
				FileInputStream fis = null;
				FileOutputStream fos = null;
				try {
					fis = new FileInputStream(file1);
					fos = new FileOutputStream(file2);
					// 3.实现文件的复制
					byte[] b = new byte[5];// 读取
					int len;// 每次读入长度
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
		// 1. 提供读入，写出的文件
		File file1 = new File("C:\\Users\\ledehui.FSTVOFFICE\\Desktop\\hj.jpg");
		File file2 = new File("C:\\Users\\ledehui.FSTVOFFICE\\Desktop\\hj1.jpg");
		// 2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[5];// 读取
			int len;// 每次读入长度
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
	
	//从硬盘读取一个文件，并写入到另一个位置（相当于文件复制）
	@Test
	public void TestFileOutputStream1() {
		// 1. 提供读入，写出的文件
		File file1 = new File("hello.txt");
		File file2 = new File("hello3.txt");
		// 2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[5];// 读取
			int len;// 每次读入长度
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

	// FileoutputStream 输出
	@Test
	public void testFileOutputStream1() {
		// 1.创建一个File对象，表明写入的文件位置。
		// 输出的物理文件可以不存在。
		// 当执行过程中，如不存在，会自动创建，如存在，会将原有的文件覆盖保存
		File file = new File("hello2.txt");
		FileOutputStream fos = null;
		// 2.创建一个FileOutputStream的对象，将file对象作为形参传递给FileOutputStream构造器中
		try {
			fos = new FileOutputStream(file);
			// 3.写入的操作
			fos.write(new String("I Love China I Love the World").getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 4.关闭输出流
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
			byte[] b = new byte[5];// 读取到的数据要写入的数组
			int len;// 每次读入到byte中字节的长度
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

	// 使用try-catch的方式处理如下异常更合理。保证流的关闭一定可以执行
	@Test
	public void testFileInputStream2() {
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = null;
		try {
			// 1.创建一个File类的对象
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			// 3.调用FileInputStream的方法，实现File文件的读取
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
			// 4.关闭相应的流
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

	// 从硬盘存在的一个文件中，读取其内容到程序中，使用FileInputStream
	// 要读取的文件一定要存在，否则抛FileNotFoundException
	@Test
	public void testFileInputStream1() throws Exception {
		// 1.创建一个File类的对象
		File file = new File("hello.txt");
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用FileInputStream的方法，实现File文件的读取
		/*
		 * read():读取文件的一个字节。当执行到文件结尾时，返回-1
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
		// 4.关闭相应的流
		fis.close();
	}

}
