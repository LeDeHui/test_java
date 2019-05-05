package Day17_1_Thread;

//  ����Runnable�ӿڷ�ʽ:��Ʊ
//ģ���վ��Ʊ����,������������,��Ʊ��Ϊ100��

/*
 *	�˳�������̰߳�ȫ���⣬��ӡ��Ʊ�������Ʊ����Ʊ
 * 1.�̰߳�ȫ������ڵ�ԭ��
 * 		����һ���߳��ڲ����������ݵĹ����У�δִ���������£���һ���̲߳�����������¹������ݴ����˰�ȫ����
 * 2.��ν���̵߳İ�ȫ���⣿
 * 		������һ���̲߳�������������Ϻ������̲߳��в��빲�����ݵĲ�����
 * 3.Java���ʵ���̵߳İ�ȫ���̵߳�ͬ������
 * 		��ʽһ��ͬ�������
	 * 		synchronized��ͬ������������
	 * 		//��Ҫ��ͬ���������飨��Ϊ�����������ݵĴ��룩
	 * 		��
 * 		1.�������ݣ�����̹߳�ͬ������ͬһ�����ݣ�������
 * 		2.ͬ������������һ����Ķ������䵱(����һ����Ķ���)���ĸ��̻߳�ȡ�˼�������˭�Ϳ���ִ��  ���� �еĴ��롣�׳ƣ���
 * 		Ҫ��
 * 			���Ե��̱߳��빲��һ����
 * 		ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ�������ʹ��this���䵱�������ڼ̳еķ�ʽ�У�����this
 * 
 * 
 * 		��ʽ����ͬ������
 * 		
 * 
 * 
 * 
 * */
class Windows2 implements Runnable {
	int ticket = 100;
	Object obj = new Object();

	public void run() {
		while (true) {
			// synchronized (obj) {
			synchronized (this) {
				//this ��ʾ��ǰ����   w

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

public class TestWindows2 {
	public static void main(String[] args) {
		Windows2 w = new Windows2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();

	}
}
