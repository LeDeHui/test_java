package Day17_1_Thread;

import java.awt.Window;
//  ����Runnable�ӿڷ�ʽ:��Ʊ
//ģ���վ��Ʊ����,������������,��Ʊ��Ϊ100��
public class TestWindows1 {
	public static void main(String[] args) {
		Windows1 w = new Windows1(); 
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();
		
	}
}
class Windows1 implements Runnable{
	int ticket = 100;
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

