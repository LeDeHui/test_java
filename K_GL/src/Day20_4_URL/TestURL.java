package Day20_4_URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//URL:统一资源定位符.一个URL的对象,对应着互联网上的一个资源
//我们可以通过URL的对象调用其相应的方法,将此资源读取("下载")
public class TestURL {

	public static void main(String[] args) throws IOException {
		//1.创建一个URL的对象
		URL url   = new URL("http://127.0.0.1:8080/examples/HelloWorld.txt?a=b" );
		 
		/*
		 * public String getProtocol(  )     获取该URL的协议名
			public String getHost(  )           获取该URL的主机名
			public String getPort(  )            获取该URL的端口号
			public String getPath(  )           获取该URL的文件路径
			public String getFile(  )             获取该URL的文件名
			public String getRef(  )             获取该URL在文件中的相对位置
			public String getQuery(   )        获取该URL的查询名


		 * */
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getPort());
//		System.out.println(url.getPath());
//		System.out.println(url.getFile());
//		System.out.println(url.getRef());
//		System.out.println(url.getQuery());
		
		//如何将服务端的资源读取进来:openStream()
		InputStream is =url.openStream();
		byte[] b = new byte[20];
		int len;
		while ((len = is.read(b))!=-1) {
			String str =new  String(b,0,len);
			System.out.println(str);
			
		}
		is.close();
		//如果既有数据的输入,又有数据的输出,则考虑URLopenConnection
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
