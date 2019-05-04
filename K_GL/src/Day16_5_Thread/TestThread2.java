package Day16_5_Thread;
 
class SubThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}

public class TestThread2 {
	public static void main(String[] args) {
		 
	}
}
