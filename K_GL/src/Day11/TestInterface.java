package Day11;

public class TestInterface {
	public static void main(String[] args) {
		Duck d1 = new Duck();
		TestInterface.test1(d1);
		TestInterface.test2(d1);
		TestInterface.test3(d1);
		
	}
	public static void test1(Runner r) {//Runner r = new Duck();
		r.run();//���ⷽ������
	}

	public static void test2(Swimmer s) {
		s.swim();
	}

	public static void test3(Flier f) {
		f.fly();
	}
}

interface Runner {
	void run();
}

interface Swimmer {
	void swim();
}

interface Flier {
	void fly();
}

class Duck implements Runner, Swimmer, Flier {

	@Override
	public void fly() {
		System.out.println("��СѼҲ���Ա�ɰ����");

	}

	@Override
	public void swim() {
		System.out.println("���Ʋ��岨");

	}

	@Override
	public void run() {
		System.out.println("Ѽ��ƨ��ŤŤ����·");

	}

}