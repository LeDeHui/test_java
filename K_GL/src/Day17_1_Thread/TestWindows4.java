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
 * 		�������������ݵķ�������Ϊsynchronized�����˷���Ϊͬ���������ܹ���֤����һ��ִ�д˷���ʱ�������߳�����ȴ�ֱ�����߳�ִ�����
 * 		>>ͬ������������this
 * 
 * 4.�߳�ͬ���ı׶ˣ�����ͬһ��ʱ��ֻ����һ���̷߳��ʹ������ݣ�Ч�ʱ����
 * 
 * */
class Windows4 implements Runnable {
	int ticket = 100;

	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {

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

public class TestWindows4 {
	public static void main(String[] args) {
		Windows4 w = new Windows4();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();

	}
}
