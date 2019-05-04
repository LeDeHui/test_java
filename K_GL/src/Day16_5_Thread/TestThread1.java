package Day16_5_Thread;

/*
 *	 Thread 的常用方法
 * 1.start():启动线程并执行相应的run()方法
 * 2.run():子线程要执行的代码放入run()方法中
 * 3.currentThread():静态的  调取当前的线程
 * 4.getName():获取此线程的名字
 * 5.setName():设置此线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join方法,表示当执行到此方法,A线程停止执行,直至B线程执行完毕,A现在在接着join方法后面在执行
 * 8.isAlive():判断当前线程是否存活
 * 9.sleep(long l):显式的让当前线程睡眠l毫秒
 * 10.线程通信:wait()  notify()  notifAll()
 * 
 * 	设置线程的优先级
 * getPriority():返回线程优先值
 * setPriority(int newPriority):改变线程的优先级
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
		s.setName("线程1");
		s.setPriority(Thread.MAX_PRIORITY);
		s.start();
		Thread.currentThread().setName("=======主线程");
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
