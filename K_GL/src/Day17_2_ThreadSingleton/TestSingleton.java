package Day17_2_ThreadSingleton;
//��������ʽ���̰߳�ȫ���⣺ʹ��ͬ������
/*
 * 	����һ��ķ����ڣ�ʹ��ͬ������飬���Կ���ʹ��this��
 * 
 * 	��Ӧ��̬�������ԣ�ʹ�õ�ǰ�౾��䵱��
 * */
class Singleton {

	private Singleton() {

	}

	private static Singleton instance = null;

	public static Singleton getInstance() {
		synchronized (Singleton.class) {
			if (instance == null) {
				instance = new Singleton();
			}
		}
		return instance;
	}

}

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);

	}
}
