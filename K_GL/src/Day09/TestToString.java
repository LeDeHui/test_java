package Day09;

import java.util.Date;

/**
 * 
 * @author ledehui toString()����
 *
 *         java.lang.object ���toString���������������� public String toString() { return
 *         getClass().getName() + "@" + Integer.toHexString(hashCode()); }
 *         1.�����Ǵ�ӡһ�����������ʱ��ʵ����Ĭ�ϵ��õľ�˵��������toString�������� 2.
 *         �����Ǵ�ӡ�Ķ�������û����дobject�е�toSting���������ǣ���ô���õľ�˵object�ж����toString��������
 *         ���ش˶������ڵ��༰��Ӧ�Ķѿռ�ʵ����׵�ֵַ
 * 
 *         3.�����Ǵ�ӡ�Ķ���������д��toString���������ǣ����õľ�˵������д��toString��������
 *
 */
public class TestToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("AA",10);
//		Person p2 = new Person();
		System.out.println(p1.toString());
		System.out.println(p1);
		//4.
		String str1 = new String("BB");
		String str2 = "AA";
		System.out.println(str1.toString());
		System.out.println(str2.toString());
		
		Date d  = new Date();
		System.out.println(d);

	}

}
class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

