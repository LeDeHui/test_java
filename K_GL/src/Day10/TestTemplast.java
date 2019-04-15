package Day10;

//模版方法设计模式
public class TestTemplast {
	public static void main(String[] args) {
		new SubTemplast().spendTime();
	}

}

class SubTemplast extends Templast {
	public void code() {
		boolean flag = false;
		for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j < Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(i);

			}
			flag = false;
		}
	}
}

abstract class Templast {
	abstract void code();

	public void spendTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}