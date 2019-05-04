package Day15_1_File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 *java.io.File��
 *1.����������,�����ص���,�ӿڶ�������java.io����
 *2.File��һ����,�����й��������������,�˶����Ӧ��һ���ļ�( .txt .avi .doc �ȵ�)���ļ�Ŀ¼
 *3.File ���������ƽ̨�޹ص�. 
 *4.File�еķ���  ���漰����δ�����ɾ�����������ȵȣ�ֻҪ�漰�ļ����ݵģ�File������Ϊ���ģ�������io�����
 *5.File��Ķ�����Ϊio���ľ�����Ĺ��������βΡ�
 *
 * 
 * */
public class TestFile {
	/*
	 * 	�ļ����������Ŀ¼�������
	 * 	�ļ��������
	 * createNewFile() �½�
	 * delete()  ɾ��
	 * 	Ŀ¼�������
	 * mkDir()����һ���ļ�Ŀ¼.ֻ�����ϲ��ļ�Ŀ¼���ڵ������,���ܷ���true
	 * mkDirs()����һ���ʼ�Ŀ¼,���ϲ��ļ�Ŀ¼������,һ������
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
	
	/*�ļ�������ȡ�ļ�������Ϣ
	 * exists()  �ж��ļ��Ƿ����
	 * canWrite() �Ƿ�ɶ�
	 * canRead()  �Ƿ��д
	 * isFile() �ж��Ƿ�Ϊһ���ļ� 
	 * isDirectory() �ж��Ƿ�Ϊһ���ļ�Ŀ¼
	 * 
	 * lastModified() �ļ�����޸�ʱ��
	 * length() ���ݴ�С
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
	 * 	·��: ����·��:�����̷����ڵ��������ļ�·�� ���·��:�ڵ�ǰ�ļ�Ŀ¼�µ��ļ�·��
	 * 	�����ļ�����
	 * 
	 *  getName() ��ȡ�ļ���;
	 *  getPath() ��ȡ�ļ�Ŀ¼; 
	 *  getAbsluteFila() ��ȡ�ļ������Ŀ¼ 
	 *  getAbslutepath() ��ȡ�ļ��ľ���Ŀ¼ 
	 *  getParent() ��ȡ�ļ�����һ��Ŀ¼
	 * renameTo(File newName) ������
	 */
	
	@Test
	public void test1() {
		File file1 = new File("D:\\IO\\helloworld.txt");
//		File file1 = new File("D:/IO/helloworld.txt"); //����
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

		// renameTo(File newName):������
		// file1.renameTo(file2):file1������Ϊfile1.
		// Ҫ��file1һ������ file2һ��������

		boolean b = file1.renameTo(file3);
		System.out.println(b);

	}

}
