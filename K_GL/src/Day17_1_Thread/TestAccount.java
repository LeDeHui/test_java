package Day17_1_Thread;

public class TestAccount {
	public static void main(String[] args) {
		Account a1 = new Account();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		t1.setName("¼×");
		t2.setName("ÒÒ");
		t1.start();
		t2.start();
	}
}

class Account implements Runnable {

	double zhanghu = 0;

	public void run() {
		for (int i = 0; i < 3; i++) {
			show();
		}
	}

	public synchronized void show() {
		notify();
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zhanghu += 100;
		System.out.println(Thread.currentThread().getName() + " : " + zhanghu);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
