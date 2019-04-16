package Day11;

//��ڵ�Ӧ��
public class TestUsb {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.dowork(new Printer());
		Flash flash = new Flash();
		com.dowork(flash);
		//X ʵ�ֽ�ڵ�������Ķ���
		
		USB phoneUsb = new USB() {

			@Override
			public void stop() {
				System.out.println("�ֻ�ֹͣ����");

			}

			@Override
			public void start() {
				System.out.println("�ֻ���ʼ����");

			}
		};
		com.dowork(phoneUsb);
		com.dowork(new USB() {
			
			@Override
			public void stop() {
				System.out.println("�ֻ�ֹͣ���ӡ�����");
				
			}
			
			@Override
			public void start() {
				System.out.println("�ֻ���ʼ���ӡ�����");
				
			}
		});
		//X ʵ�ֽ�ڵ�������Ķ���
	}
}

class Computer {
	public void dowork(USB usb) {
		usb.start();
		System.out.println("���豸��ʼ������������");
		usb.stop(); 
		System.out.println();
	}
}

interface USB {
	// USB�ĳߴ��С����������Ϊ����

	// ��������Ϊ���󷽷�
	void start();

	void stop();

}

//��ӡ��
class Printer implements USB {

	@Override
	public void start() {
		System.out.println("��ӡ����ʼ����");

	}

	@Override
	public void stop() {
		System.out.println("��ӡ����������");

	}

}

//u��
class Flash implements USB {
	public void start() {
		System.out.println("U�̿�ʼ����");
	}

	public void stop() {
		System.out.println("U��ֹͣ����");
	}
}