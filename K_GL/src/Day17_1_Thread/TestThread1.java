package Day17_1_Thread;

/*
 * 	�������̵߳ķ�ʽ��:ͨ��ʵ�ֵķ���
 * 1.����һ��ʵ����Runnable�ӿڵ���
 * 2.ʵ�ֽӿڵĳ��󷽷�
 * 3.����һ��Runnable�ӿ�ʵ����Ķ���
 * 4.���˶�����Ϊ�βδ��ݸ�Thread��Ĺ�������,����Thread��Ķ���,�˶���Ϊһ���߳�
 * 5.����start()����:�����̲߳�ִ��run()����
 * 
 * 
 * 
 * 
 * �Ա�һ�¼̳з���VSʵ�ַ���
 * 1.��ϵ: public class Thread   implementd Runnable
 * 2.�ĸ���ʽ��?  ʵ�ַ�ʽ���ڼ̳еķ�ʽ
 * 	   �ٱ�����Java���̳еľ�����ʵ��
 * 	   ���������̲߳���ͬһ����Դ(����),������ʵ�ֵķ�ʽ
 * 
 * 
 * 
 * */
//1
class printNum1 implements Runnable {
	//2
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		//3
		printNum1 p = new printNum1();
		//Ҫ������һ�����߳�,�������start()
		//4
		Thread t1 = new Thread(p);
		//5
		t1.start();//�����߳�,ִ��Thread���������ǹ������βεĶ����run()����.
		 //�ٴ���һ���߳�
		Thread t2 = new Thread(p);
		t2.start();
	}
}
