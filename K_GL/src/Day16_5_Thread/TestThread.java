package Day16_5_Thread;

/*
 *	 ����һ�����߳�,���1-100֮����Ȼ�������    ͬ����,���߳�ִ��ͬ���Ĳ���
 * 	�������̵߳ĵ�һ�ַ�ʽ:�̳�java.lang.Thread��
 * 
 * */
//�����̰߳�ȫ����
//1.����һ���̳�Thread������
class SubThread extends Thread {
	//2. ��дThread���run����, ������ʵ�����߳�Ҫ��ɵĹ���
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +":"+i);
		}
	}

}

public class TestThread {
	public static void main(String[] args) {
		//3.����һ������Ķ���
		SubThread s = new SubThread();
		SubThread s1 = new SubThread();	
		//4.�����̵߳�start()����:  1.�������߳�  2.���ö�Ӧ��run()����
		s.start();
		//5.һ���߳�ֻ��ִ��һ��start()
		//s.start();
		//����ͨ��Threadʵ�������run()ȥ����һ���߳�
		//s.run();			 
		s1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +":"+i);
		}
		
		
	}
}
