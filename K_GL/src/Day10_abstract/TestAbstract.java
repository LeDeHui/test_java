package Day10_abstract;

/*
 * abstract  ����ģ��������������࣬����
 * 1.abstract �����࣬������
 * 	1���ɱ�ʵ����
 * 	2�������й������������඼�й�������
 * 	3���󷽷����ڵ��࣬һ���ǳ�����
 * 	4�������п���û�г��󷽷���
 *   >>>���������һ���࣬����Ҫ���������ʵ��ʱ�򣬾Ϳ��Կ��ǽ�������Ϊ�����࣬������ʵ�������ĳ��󷽷�
 * 2abstract���η��������󷽷�
 * 	1��ʽ��û�з����壬������������ �磺public abstract void eat();
 * 	2���󷽷�ֻ���������Ĺ��ܣ��������ִ�н����̳г���������࣬��������д�˳��󷽷�
 * 	3������̳г����࣬����д�����г��󷽷���������˵һ����ʵ���࡯���������Ա�ʵ����
 * 	4������û�гг����࣬û����д���г��󷽷�����ζ����������г��󷽷���������������Ϊ������
 * 
 * 
 * 
 * */
public class TestAbstract {
	public static void main(String[] args) {
//	Person p1 = new Person();
//	p1.eat();
		Student s1 = new Student();
		s1.eat();
		Person p1 = new Worlk();
		p1.eat();
	}
}

abstract class Person {
	String name;

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

//	public void eat() {
//		System.out.println("eat");
//	}
//
//	public void walk() {
//		System.out.println("walk");
//	}
	public abstract void eat();
	public abstract void walk();
}

class Student extends Person {
	public void eat() {
		System.out.println("Student eat");
	}

	public void walk() {
		System.out.println("Student walk");
	}
}

class Worlk extends Person {
	public void eat() {
		System.out.println("Worlk eat");
	}

	public void walk() {
		System.out.println("Worlk walk");
	}
}