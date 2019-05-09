package Day20_4_URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//URL:ͳһ��Դ��λ��.һ��URL�Ķ���,��Ӧ�Ż������ϵ�һ����Դ
//���ǿ���ͨ��URL�Ķ����������Ӧ�ķ���,������Դ��ȡ("����")
public class TestURL {

	public static void main(String[] args) throws IOException {
		//1.����һ��URL�Ķ���
		URL url   = new URL("http://127.0.0.1:8080/examples/HelloWorld.txt?a=b" );
		 
		/*
		 * public String getProtocol(  )     ��ȡ��URL��Э����
			public String getHost(  )           ��ȡ��URL��������
			public String getPort(  )            ��ȡ��URL�Ķ˿ں�
			public String getPath(  )           ��ȡ��URL���ļ�·��
			public String getFile(  )             ��ȡ��URL���ļ���
			public String getRef(  )             ��ȡ��URL���ļ��е����λ��
			public String getQuery(   )        ��ȡ��URL�Ĳ�ѯ��


		 * */
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getPort());
//		System.out.println(url.getPath());
//		System.out.println(url.getFile());
//		System.out.println(url.getRef());
//		System.out.println(url.getQuery());
		
		//��ν�����˵���Դ��ȡ����:openStream()
		InputStream is =url.openStream();
		byte[] b = new byte[20];
		int len;
		while ((len = is.read(b))!=-1) {
			String str =new  String(b,0,len);
			System.out.println(str);
			
		}
		is.close();
		//����������ݵ�����,�������ݵ����,����URLopenConnection
		URLConnection urlConn  = url.openConnection();
		InputStream is1 = urlConn.getInputStream();
		FileOutputStream fos = new FileOutputStream("abc.txt");
		
		byte[] b1 = new byte[20];
		int len1;
		while ((len1 = is1.read(b1))!=-1) {
			fos.write(b, 0, len1);
			
		}
		fos.close();
		is1.close();
		
	}

}
