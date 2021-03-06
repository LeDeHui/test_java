package Day20_3_TCPUDP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//TCP编程示例三:从客户端发送文件给服务端,服务端保存到本地,并返回"发送成功给客户端",并关闭相应的连接
public class TestTCP3 {
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		FileInputStream fis = null;
		InputStream is = null;

		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9094);
			os = socket.getOutputStream();
			fis = new FileInputStream("hj.jpg");
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
			}

			socket.shutdownOutput();

			is = socket.getInputStream();
			byte[] b1 = new byte[1024];
			int len1;
			while ((len1 = is.read(b1)) != -1) {
				String string1 = new String(b1, 0, len1);
				System.out.println(string1);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (os != null) {

				try {
					os.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (socket != null) {

				try {
					socket.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		FileOutputStream fos = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9094);
			s = ss.accept();
			is = s.getInputStream();
			fos = new FileOutputStream("hj4.jpg");

			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			System.out.println(s.getInetAddress().getHostName());
			os = s.getOutputStream();
			os.write("Over".getBytes());
			s.shutdownOutput();
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		}

	}

}
