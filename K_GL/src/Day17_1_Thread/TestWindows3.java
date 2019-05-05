package Day17_1_Thread;


//ģ���վ��Ʊ����,������������,��Ʊ��Ϊ100��
public class TestWindows3 {
	public static void main(String[] args) {
		Windows3 w1 = new Windows3();
		Windows3 w2 = new Windows3();
		Windows3 w3 = new Windows3();
		w1.setName("����һ");
		w2.setName("���ڶ�");
		w3.setName("������");
		
		w1.start();
		w2.start();
		w3.start();
		
		
		 
		
	}
} 

class Windows3 extends Thread {

	static int ticket = 100; 
	public void run() {
		while (true) {
			synchronized (this) {//�ڱ������У�  this��ʾw1,w2,w3
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ,Ʊ��Ϊ" + ticket--);

				} else {
					break;
				}
			}
		}
	}
}
