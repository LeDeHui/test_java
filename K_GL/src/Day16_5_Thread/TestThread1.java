package Day16_5_Thread;

/*
 *	 Thread �ĳ��÷���
 * 1.start():�����̲߳�ִ����Ӧ��run()����
 * 2.run():���߳�Ҫִ�еĴ������run()������
 * 3.currentThread():��̬��  ��ȡ��ǰ���߳�
 * 4.getName():��ȡ���̵߳�����
 * 5.setName():���ô��̵߳�����
 * 6.yield():���ô˷������߳��ͷŵ�ǰCPU��ִ��Ȩ
 * 7.join():��A�߳��е���B�̵߳�join����,��ʾ��ִ�е��˷���,A�߳�ִֹͣ��,ֱ��B�߳�ִ�����,A�����ڽ���join����������ִ��
 * 8.isAlive():�жϵ�ǰ�߳��Ƿ���
 * 9.sleep(long l):��ʽ���õ�ǰ�߳�˯��l����
 * 10.�߳�ͨ��:wait()  notify()  notifAll()
 * 
 * 	�����̵߳����ȼ�
 * getPriority():�����߳�����ֵ
 * setPriority(int newPriority):�ı��̵߳����ȼ�
 * 
 * 
 * */
class SubThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}

public class TestThread1 {
	public static void main(String[] args) {
		SubThread1 s = new SubThread1();
		s.setName("�߳�1");
		s.setPriority(Thread.MAX_PRIORITY);
		s.start();
		Thread.currentThread().setName("=======���߳�");
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
//			if (i % 5 == 0) {
//				Thread.currentThread().yield();
//			}
//			if (i == 20) {
//				try {
//					s.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}

	}
}
