package Day17_1_Thread;

import java.awt.Window;

//模拟火车站售票窗口,开启三个窗口,总票数为100张
public class TestWindows {
	public static void main(String[] args) {
		Windows w1 = new Windows();
		Windows w2 = new Windows();
		Windows w3 = new Windows();
		w1.setName("窗口一");
		w2.setName("窗口二");
		w3.setName("窗口三");
		
		w1.start();
		w2.start();
		w3.start();
		
		
		 
		
	}
} 

class Windows extends Thread {

	static int ticket = 100;
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
