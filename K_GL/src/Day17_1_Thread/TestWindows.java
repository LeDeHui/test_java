package Day17_1_Thread;

import java.awt.Window;

//ģ���վ��Ʊ����,������������,��Ʊ��Ϊ100��
public class TestWindows {
	public static void main(String[] args) {
		Windows w1 = new Windows();
		Windows w2 = new Windows();
		Windows w3 = new Windows();
		w1.setName("����һ");
		w2.setName("���ڶ�");
		w3.setName("������");
		
		w1.start();
		w2.start();
		w3.start();
		
		
		 
		
	}
} 

class Windows extends Thread {

	static int ticket = 100;
	public void run() {
		while (true) {
			if (ticket > 0) {
				 
				System.out.println(Thread.currentThread().getName() + "��Ʊ,Ʊ��Ϊ" + ticket--);

			} else {
				break;
			}
		}
	}
}
