package Day20_3_TCPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

public class TestUDP {
	// ���Ͷ�
	@Test
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "����Ҫ���͵�����".getBytes();
			// ����һ�����ݱ�,ÿһ�����ݱ����ܴ���64K,ÿһ������¼������Ϣ,���Ͷ�IP�˿ں� �Լ����͵��Ľ��ն˵�IP���˿ں�
			DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
			ds.send(pack);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}

	// ���ն�
	@Test
	public void rceive() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			DatagramPacket pack = new DatagramPacket(b, 0, b.length);
			ds.receive(pack);
			String string = new String(pack.getData(), 0, pack.getLength());
			System.out.println(string);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ds.close();
		}
	}

}
