package Day17_5_ProduceeConsums;

//生产者/消费者  问题
/*生产者将产品交给店员，消费者从店员出取走
 * 	店员依次只能持有固定数量的产品（比如20），
 * 	如果生产者试图生产更多的产品，店员会叫生产者停一下
 * 	如果店中有空位放产品了再通知生产者生产；
 * 	如果店中没有产品，店员会告诉消费者等一下，
 * 	如果店中有产品了再通知消费者取走
 * 
 * 
 * 	
 * 
 * */

class Clerk {
	int product;

	public synchronized void add() {
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println(Thread.currentThread().getName() + ":生产" + product);
			notifyAll();
		}
	}

	public synchronized void mis() {
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			product--;
			System.out.println(Thread.currentThread().getName() + ":消费" + product);
			notifyAll();
		}
	}
}

class Producer implements Runnable {// 生产者
	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		while (true) {
			try { 
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.add();
		}
	}
}

class xiaofeizhe implements Runnable {
	Clerk clerk;

	public xiaofeizhe(Clerk clerk) {
		try { 
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while (true) {
			clerk.mis();
		}

	}

}

public class TestProduceeConsums {
	public static void main(String[] args) {
		Clerk c = new Clerk();
		xiaofeizhe xfz = new xiaofeizhe(c);
		Producer p = new Producer(c);
		Thread t1 = new Thread(xfz);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(p);
		t1.setName("消费者1");
		t2.setName("生产者1");
		t3.setName("生产者2");
		t2.start();
		t1.start();
		t3.start();

	}
}
