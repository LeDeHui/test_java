package Day11;

//借口的应用
public class TestUsb {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.dowork(new Printer());
		Flash flash = new Flash();
		com.dowork(flash);
		//X 实现借口的匿名类的对象
		
		USB phoneUsb = new USB() {

			@Override
			public void stop() {
				System.out.println("手机停止连接");

			}

			@Override
			public void start() {
				System.out.println("手机开始连接");

			}
		};
		com.dowork(phoneUsb);
		com.dowork(new USB() {
			
			@Override
			public void stop() {
				System.out.println("手机停止连接。。。");
				
			}
			
			@Override
			public void start() {
				System.out.println("手机开始连接。。。");
				
			}
		});
		//X 实现借口的匿名类的对象
	}
}

class Computer {
	public void dowork(USB usb) {
		usb.start();
		System.out.println("此设备开始操作。。。。");
		usb.stop(); 
		System.out.println();
	}
}

interface USB {
	// USB的尺寸大小，可以设置为常量

	// 功能设置为抽象方法
	void start();

	void stop();

}

//打印机
class Printer implements USB {

	@Override
	public void start() {
		System.out.println("打印机开始工作");

	}

	@Override
	public void stop() {
		System.out.println("打印机结束工作");

	}

}

//u盘
class Flash implements USB {
	public void start() {
		System.out.println("U盘开始工作");
	}

	public void stop() {
		System.out.println("U盘停止工作");
	}
}