package Day16_5_Thread;

/*
 *	 创建一个子线程,完成1-100之间自然数的输出    同样的,主线程执行同样的操作
 * 	创建多线程的第一种方式:继承java.lang.Thread类
 * 
 * */
//1.创建一个继承Thread的子类
class SubThread extends Thread {
	//2. 重写Thread类的run方法, 方法内实现子线程要完成的功能
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +":"+i);
		}
	}

}

public class TestThread {
	public static void main(String[] args) {
		//3.创建一个子类的对象
		SubThread s = new SubThread();
		SubThread s1 = new SubThread();	
		//4.调用线程的start()方法:  1.启动此线程  2.调用对应的run()方法
		s.start();
		//5.一个线程只能执行一次start()
		//s.start();
		//不能通过Thread实现类对象run()去启动一个线程
		//s.run();			 
		s1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +":"+i);
		}
		
		
	}
}
