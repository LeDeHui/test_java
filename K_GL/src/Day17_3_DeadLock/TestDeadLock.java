package Day17_3_DeadLock;

/*
 * 	死锁的问题：处理线程同步时容易出现
 * 	不同的线程分别占有对方的同步资源不放弃，等在等待对方放弃自己需要的同步资源，就形成了线程死锁
 * 
 * 	写代码时，要避免死锁！
 * */
class TestDeadLock {

	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				synchronized (sb1) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sb1.append("A");
					synchronized (sb2) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
		new Thread() {
			public void run() {
				synchronized (sb2) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sb1.append("A");
					synchronized (sb1) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
	}

}
