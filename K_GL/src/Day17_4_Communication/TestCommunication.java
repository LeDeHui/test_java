package Day17_4_Communication;

/*	
 * 
 * //�߳�ͨ��:���µ������ؼ���ʹ�õĻ���������ͬ��������ͬ��������
 * wait()��һ��һ���߳�ִ�е�wait�������ͷŵ�ǰ������
 * notify()/notifyAll()������wait������һ���������߳�
 * 
 * 
 * 
 * 	ʹ�������̴߳�ӡ1-100���߳�1���߳�2 �����ӡ	
 * 
 * */

class printNum implements Runnable {
	int num = 1;

	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (num <= 100) {
					try {
						Thread.currentThread().sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + num);
					num++;
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}

public class TestCommunication {
	public static void main(String[] args) {

		printNum p = new printNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("��");
		t2.setName("��");
		t1.start();
		t2.start();
	}
}
