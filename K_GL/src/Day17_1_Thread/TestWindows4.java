package Day17_1_Thread;

//  适用Runnable接口方式:售票
//模拟火车站售票窗口,开启三个窗口,总票数为100张

/*
 *	此程序存在线程安全问题，打印车票会出现重票，错票
 * 1.线程安全问题存在的原因？
 * 		由于一个线程在操作共享数据的过程中，未执行完的情况下，另一个线程参与进来，导致共享数据存在了安全问题
 * 2.如何解决线程的安全问题？
 * 		必须让一个线程操作共享数据完毕后，其他线程才有参与共享数据的操作。
 * 3.Java如何实现线程的安全：线程的同步机制
 * 		方式一：同步代码块
	 * 		synchronized（同步监视器）｛
	 * 		//需要被同步到额代码块（即为操作共享数据的代码）
	 * 		｝
 * 		1.共享数据：多个线程共同操作的同一个数据（变量）
 * 		2.同步监视器：由一个类的对象来充当(任意一个类的对象)。哪个线程获取此监视器，谁就可以执行  ｛｝ 中的代码。俗称：锁
 * 		要求：
 * 			所以的线程必须共有一把锁
 * 		注：在实现的方式中，考虑同步的话，可以使用this来充当。但是在继承的方式中，慎用this
 * 
 * 
 * 		方式二：同步方法
 * 		将操作共享数据的方法声明为synchronized。即此方法为同步方法，能够保证其中一个执行此方法时，其他线程在外等待直至此线程执行完成
 * 		>>同步方法的锁：this
 * 
 * 4.线程同步的弊端：由于同一个时间只能有一个线程访问共享数据，效率变低了
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
			System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);
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
