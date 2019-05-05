package Day17_1_Thread;

//  适用Runnable接口方式:售票
//模拟火车站售票窗口,开启三个窗口,总票数为100张
public class TestWindows1 {
	public static void main(String[] args) {
		Windows1 w = new Windows1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();

	}
}

class Windows1 implements Runnable {
	int ticket = 100;

	public void run() {
		while (true) {
			if (ticket > 0) {

				System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);

			} else {
				break;
			}
		}
	}
}
