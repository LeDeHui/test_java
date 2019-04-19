package Day12_1_finally;

public class TestFinally {
	public static void main(String[] args) {
		TestFinally t1 = new TestFinally();
		System.out.println(t1.method1());
	}

	@SuppressWarnings("finally")
	public static int method1() {
		try {
			System.out.println("try");
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return 6;
		} finally {
			System.out.println("Finally");
			return 0;
		}
	}
}
