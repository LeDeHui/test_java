package Day17_1_Thread;

//ģ���վ��Ʊ����,������������,��Ʊ��Ϊ100��
//�����̰߳�ȫ����  
public class TestWindows5 {
	public static void main(String[] args) {
		Windows5 w1 = new Windows5();
		Windows5 w2 = new Windows5();
		Windows5 w3 = new Windows5();
		w1.setName("����һ");
		w2.setName("���ڶ�");
		w3.setName("������");

		w1.start();
		w2.start();
		w3.start();

	}
}

class Windows5 extends Thread {

	static int ticket = 100;

	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {//this  w1,w2,w3
		
		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��Ʊ,Ʊ��Ϊ" + ticket--);

		}

	}
}
