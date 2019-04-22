package Day12_2_Exception;

public class ReturnRExceptionDemo {
	static void methodA() {
		try {
			System.out.println("进入方法A");
			throw new RuntimeException("制造异常");
		} finally {
			System.out.println("调用A方法的finally");
		}
	}

	static void methodB() {
		try {
			System.out.println("进入方法B");
		} finally {
			System.out.println("调用B方法的finally");
		}
	}

	public static void main(String[] args) {
		try {
			methodA();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		methodB();

	}
}
