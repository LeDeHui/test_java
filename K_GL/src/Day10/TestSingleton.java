package Day10;

/* ���ģʽ:���ģʽ���ڴ���ʵ�����ܽ�����ۻ�֮����ѡ�Ĵ���ṹ,��̷��,�Լ���������˼����ʽ 
 * 23�����ģʽ.
 * 
 * 	�������ģʽ
 * 1.���������:ʹ��һ����ֻ�ܹ�����һ������
 * 2.���ʵ��?
 *		1.˽�л�������,ʹ��������ⲿ���ܵ��ô˹�����
		2.������ڲ�����һ�����ʵ��
		3.˽�л��˶���,ͨ�������ķ���������
 		4.�˹����ķ���,ֻ��ͨ����������,�������Ϊstatic��,ͬʱ,���ʵ��Ҳ������static������
 * 
 * 
 * 
 * */
//����ʽ  
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}

}

class Singleton {
	// 1.˽�л�������,ʹ��������ⲿ���ܵ��ô˹�����
	private Singleton() {

	}

	// 2.������ڲ�����һ�����ʵ��
	private static Singleton instance = new Singleton();

	// 3.˽�л��˶���,ͨ�������ķ���������
	// 4.�˹����ķ���,ֻ��ͨ����������,�������Ϊstatic��,ͬʱ,���ʵ��Ҳ������static������
	public static Singleton getInstance() {
		return instance;
	}

}