package Day11_InnerClass;

import Day11_InnerClass.Person.Bord;

//�ڲ���
/*
 * ��ĵ������Ա���ڲ���
 * 1.�൱��˵�����ǿ���������ڲ��ٶ����ࡣ����Ľ��ⲿ�࣬�ڲ��Ľ��ڲ���
 * 2.�ڲ���ķ��ࣺ
 * 		1����Ա�ڲ��ࣺ���������ڲ��ҷ�����
 * 		2���ֲ��ڲ��ࣺ���������ڲ��ҷ�����
 * 3.��Ա�ڲ��ࣺ
 * 		3.1���ⲿ���һ����Ա��
 * 			1�����������η���4����
 * 			2��static  final  
 * 			3�����Ե����ⲿ������Է���
 * 		3.2��������ص㣺
 * 			1��abstract
 * 			2�������������ڲ��������ԣ�����,������
 * 4.�ֲ��ڲ��ࣺ
 * 5.�����ڲ��࣬�����������㣺
 * 		1����δ�����Ա�ڲ������(�紴��Bird���� ��Dog���� �Ķ���)
 * 		2��������ֵ����ⲿ�࣬�ڲ���ı���(�����Ǳ�������ʱ)
 * 		3���ֲ��ڲ����ʹ��   (��TestInnerClass1.java)
 * 
 * */
public class TestInnerClass {
	public static void main(String[] args) {
		// ������̬�ڲ���Ķ��󣬿���ֱ��ͨ���ⲿ����þ�̬�ڲ���Ĺ�����
		Person.Dog d = new Person.Dog();
		// �����Ǿ�̬���ڲ���Ķ��󣺱����ȴ����ⲿ��Ķ���ͨ���ⲿ��Ķ�������ڲ���Ĺ�����
		Person p = new Person();
		Person.Bord b = p.new Bord();
		b.info();
		b.setName("����");

	}

}

class Person {
	String name = "����";
	int age;

	// ��Ա�ڲ��ࣨ�Ǿ�̬��
	class Bord {
		String name = "����";
		int id;

		public Bord() {

		}

//2��������ֵ����ⲿ�࣬�ڲ���ı���(�����Ǳ�������ʱ)
		public void setName(String name) {
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Person.this.name);
		}

		public void info() {
			show();
		}
	}

	// ��Ա�ڲ��ࣨ��̬��
	static class Dog {

	}

	public void method1() {
		class A {

		}
	}

	private void show() {
		System.out.println("����showһ��");
	}
}
