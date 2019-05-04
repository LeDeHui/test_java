package Day17_1_Thread;

/*
 * 	创建多线程的方式二:通过实现的方法
 * 1.创建一个实现了Runnable接口的类
 * 2.实现接口的抽象方法
 * 3.创建一个Runnable接口实现类的对象
 * 4.将此对象作为形参传递给Thread类的构造器中,创建Thread类的对象,此对象即为一个线程
 * 5.调用start()方法:启动线程并执行run()方法
 * 
 * 
 * 
 * 
 * 对比一下继承方法VS实现方法
 * 1.联系: public class Thread   implementd Runnable
 * 2.哪个方式好?  实现方式优于继承的方式
 * 	   ①避免了Java单继承的局限性实现
 * 	   ②如果多个线程操作同一份资源(数据),更适用实现的方式
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
		//要想启动一个多线程,必须调用start()
		//4
		Thread t1 = new Thread(p);
		//5
		t1.start();//启动线程,执行Thread对象生成是构造器形参的对象的run()方法.
		 //再创建一个线程
		Thread t2 = new Thread(p);
		t2.start();
	}
}
