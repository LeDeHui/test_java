package Day09_1;

/*
 * static,��̬�ģ����������������ԣ�����������飬�ڲ���
 * 
 * static ��������(�����):
 * 1.���ഴ�������ж���,��������һ������
 * 2.������һ������Դ�������޸�,�ᵼ���������Զ���Դ����Ե�һ������.vsʵ����������static���ε����ԣ����Զ���ӵ��һ�׸�����
 * 3.�������������ļ��ض����ص�,�����Ƕ�һ��
 * 4.��̬�ı��˿���ֱ��ͨ��  ��.����� ����ʽ������
 * 5.������ļ�����Ҫ���ڶ����,���Ե��ж����Ժ󣬿���  ����.����� ʹ�ã����� ��.ʵ������ �ǲ��е�
 * 6.����������ھ�̬����
 * 
 * 
 * static ���η���-�෽��
 * 1.������ļ��ض����أ����ڴ���Ҳ�Ƕ�һ��
 * 2.����ֱ��ͨ�� '��.�෽��' �ķ�������.
 * 3.�ڲ����Ե��þ�̬�����Ի򷽷�,�����ܵ��÷Ǿ�̬�����Է���.����,�Ǿ�̬�ķ������Ե��þ�̬�����Ի򷽷�
 * 		>>>��̬�ķ����ڲ�������this�ؼ���
 *      ��̬�Ľṹ(static������,����,�����,�ڲ���)����������Ҫ���ڷǾ�̬�Ľṹ,ͬʱ������ҲҪ���ڷǾ�̬�Ľṹ
 * 
 * 
 * 
 * 
 * 
 * */
public class TestSprtsMan {
	public static void main(String[] args) {
		SportMan s1 = new SportMan("�յ»�", 26);
		SportMan s2 = new SportMan("�յ»�", 15);
		s1.nation = "china";
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(SportMan.nation);
//		SportMan.shou1();
		SportMan.show2();
	}
}

class SportMan {
	// ʵ������ ���Ŷ���Ĵ����������ص�
	String name;
	int age;
	// ����� ������ļ��ض�����
	static String nation;

	public SportMan(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "SportMan [name=" + name + ", age=" + age + ",nation=" + nation + "]";
	}

	static public void show1() {
		System.out.println("����һ�������й����˶�Ա");
	}

	static public void show2() {
		System.out.println("nation:" + nation);
		info();
//		System.out.println("age :" + age);
		System.out.println("����һ�������й����˶�Ա");
	}

	public static void info() {
		System.out.println("���Ǿ�̬�ķ���");
	}
}