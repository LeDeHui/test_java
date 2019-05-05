package Day17_1_Thread;


//模拟火车站售票窗口,开启三个窗口,总票数为100张
public class TestWindows3 {
	public static void main(String[] args) {
		Windows3 w1 = new Windows3();
		Windows3 w2 = new Windows3();
		Windows3 w3 = new Windows3();
		w1.setName("窗口一");
		w2.setName("窗口二");
		w3.setName("窗口三");
		
		w1.start();
		w2.start();
		w3.start();
		
		
		 
		
	}
} 

class Windows3 extends Thread {

	static int ticket = 100; 
	public void run() {
		while (true) {
			synchronized (this) {//在本问题中，  this表示w1,w2,w3
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);

				} else {
					break;
				}
			}
		}
	}
}
