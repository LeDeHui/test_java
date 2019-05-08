package Day20_2_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * ����ͨ�ŵĵ�һ��Ҫ��:IP��ַ.ͨ��IP��ַ,Ψһ�Ķ�λ��������һ̨����
 * InetAddress:  λ��java.net����
 * 1.InetAddress��������IP��ַ.һ��InetAddress�Ķ���ʹ���һ��IP��ַ
 * 2.��δ���InertAddress�Ķ���:getByNam(String host)
 * 3.getHostName():��ȡIP��ַ��Ӧ������
 * 		getHostAddress():��ȡIP��ַ
 * 
 * */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
//		����һ��inetAddress
		InetAddress inet = InetAddress.getByName("www.fstvgo.com");
		System.out.println(inet);
		//��������
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		 
		//��ȡ������IP
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1); 
		System.out.println(inet1.getHostName());
		System.out.println(inet1.getHostAddress());
	}
}
