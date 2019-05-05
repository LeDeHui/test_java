package Day17_1_Thread;

//模拟火车站售票窗口,开启三个窗口,总票数为100张
//存在线程安全问题  
public class TestWindows5 {
	public static void main(String[] args) {
		Windows5 w1 = new Windows5();
		Windows5 w2 = new Windows5();
		Windows5 w3 = new Windows5();
		w1.setName("窗口一");
		w2.setName("窗口二");
		w3.setName("窗口三");

		w1.start();
		w2.start();
		w3.start();

	}
}

class Windows5 extends Thread {

	static int ticket = 100;

	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {//this  w1,w2,w3
		
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
