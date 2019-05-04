package Day15_1_File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 *java.io.File类
 *1.凡是与输入,输出相关的类,接口都定义在java.io包下
 *2.File是一个类,可以有构造器创建其对象,此对象对应着一个文件( .txt .avi .doc 等等)或文件目录
 *3.File 类对象是与平台无关的. 
 *4.File中的方法  仅涉及到如何创建，删除，重命名等等，只要涉及文件内容的，File是无能为力的，必须由io流完成
 *5.File类的对象常作为io流的具体类的构造器的形参。
 *
 * 
 * */
public class TestFile {
	/*
	 * 	文件操作相关与目录操作相关
	 * 	文件操作相关
	 * createNewFile() 新建
	 * delete()  删除
	 * 	目录操作相关
	 * mkDir()创建一个文件目录.只有在上层文件目录存在的情况下,才能返回true
	 * mkDirs()创建一个问价目录,若上层文件目录不存在,一并创建
	 * list()
	 * listFiles()
	 * 
	 * */
	@Test
	public void test3() throws IOException {
		File file1 = new File("D:\\IO\\helloworld.txt");  
		File file2 = new File("D:\\IO\\io1");
		System.out.println(file1.delete());
		if (!file1.exists()) {
			boolean b = file1.createNewFile();
			System.out.println(b);
		}
		
		File file3 = new File("d:\\IO\\io2");
		if(!file3.exists()) {
			System.out.println(file3.mkdir());
		}
		System.out.println();
		File file4 = new File("d:\\io");
		String [] strs = file4.list();
		for (int i = 0 ;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		
		File[] files = file4.listFiles();
		for (int i = 0 ;i<files.length;i++) {
			System.out.println(files[i].getName());
		}
	}
	
	/*文件检测与获取文件常规信息
	 * exists()  判断文件是否存在
	 * canWrite() 是否可读
	 * canRead()  是否可写
	 * isFile() 判断是否为一个文件 
	 * isDirectory() 判断是否为一个文件目录
	 * 
	 * lastModified() 文件最后修改时间
	 * length() 内容大小
	 * 
	 * */
	@Test
	public void test2() {
		File file1 = new File("D:\\IO\\helloworld.txt");  
		File file2 = new File("D:\\IO\\io1");
		
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		System.out.println();
		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory()) ;
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());
	}
	
	/*
	 * 	路径: 绝对路径:包括盘符在内的完整的文件路径 相对路径:在当前文件目录下的文件路径
	 * 	访问文件名：
	 * 
	 *  getName() 获取文件名;
	 *  getPath() 获取文件目录; 
	 *  getAbsluteFila() 获取文件的相对目录 
	 *  getAbslutepath() 获取文件的绝对目录 
	 *  getParent() 获取文件的上一级目录
	 * renameTo(File newName) 重命名
	 */
	
	@Test
	public void test1() {
		File file1 = new File("D:\\IO\\helloworld.txt");
//		File file1 = new File("D:/IO/helloworld.txt"); //或者
		File file2 = new File("helloworld.txt");
		File file3 = new File("D:\\IO\\io1");
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getParent());
		System.out.println(file1.getAbsolutePath());

		System.out.println();

		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());

		// renameTo(File newName):重命名
		// file1.renameTo(file2):file1重名名为file1.
		// 要求file1一定存在 file2一定不存在

		boolean b = file1.renameTo(file3);
		System.out.println(b);

	}

}
