package Day17_5_ProduceeConsums;

//������/������  ����
/*�����߽���Ʒ������Ա�������ߴӵ�Ա��ȡ��
 * 	��Ա����ֻ�ܳ��й̶������Ĳ�Ʒ������20����
 * 	�����������ͼ��������Ĳ�Ʒ����Ա���������ͣһ��
 * 	��������п�λ�Ų�Ʒ����֪ͨ������������
 * 	�������û�в�Ʒ����Ա����������ߵ�һ�£�
 * 	��������в�Ʒ����֪ͨ������ȡ��
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
			System.out.println(Thread.currentThread().getName() + ":����" + product);
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
			System.out.println(Thread.currentThread().getName() + ":����" + product);
			notifyAll();
		}
	}
}

class Producer implements Runnable {// ������
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
		t1.setName("������1");
		t2.setName("������1");
		t3.setName("������2");
		t2.start();
		t1.start();
		t3.start();

	}
}
