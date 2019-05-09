package Day20_3_Socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//TCP�����һ:�ͻ��˸�����˷�����Ϣ,������������Ϣ������̨��
//������ʵ������Socket���
public class TestTCP1 {
	// �ͻ���
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			// 1.����Socket�Ķ���,ͨ��������ָ������˵�IP��ַ,�Լ�����ܳ���Ķ˿ں�
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			// 2.getOutputStream():��������,��������OutputStream�Ķ���
			os = socket.getOutputStream();
			// 3.������������
			os.write("���ǿͻ���,������ ".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4.�ر���Ӧ������Socket
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ����� 
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			// ����ServerSocket�Ķ���,ͨ��������ʵ������Ķ˿ں�
			ss = new ServerSocket(9090);
			// 2.������accept()����:����һ��Socket�Ķ���
			s = ss.accept();
			// 3.����Socket()�����getInputStream()��ȡһ���ӿͻ��˷��͹�����������
			is = s.getInputStream();
			// 4.�Ի�ȡ�������еĲ���
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			System.out.println("�յ�������"+ s.getInetAddress().getHostName() +" ������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
