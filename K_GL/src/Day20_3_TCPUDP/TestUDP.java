package Day20_3_TCPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

public class TestUDP {
	// 发送端
	@Test
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "我是要发送的数据".getBytes();
			// 创建一个数据报,每一个数据报不能大于64K,每一个都记录数据信息,发送端IP端口号 以及发送到的接收端的IP及端口号
			DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
			ds.send(pack);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}

	// 接收端
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
