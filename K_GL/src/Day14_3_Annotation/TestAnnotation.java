package Day14_3_Annotation;

import java.util.List;
import java.util.ArrayList;

/*
 * 
 * ע�⣺Annotstion
 * 1.JDK�ṩ�ĳ��õ�ע��
	 * 	@Override���޶���д���෽������ע��ֻ�����ڷ���
	 * 	@Deprecated:���ڱ�ʾĳ������Ԫ�أ��࣬�����ȣ�һ��ʱ
	 * 	@SuppressWarnings:���Ʊ���������
 * 2.����Զ���ע�⣺ --> MyAnnotation
 * 
 * 3.Ԫע��
 * 
 * 
 * */
public class TestAnnotation {
	public static void main(String[] args) {
		Person p = new Student(); 
		p.walk();
		p.eat();

		@SuppressWarnings({ "rawtypes", "unused" })
		List liat = new ArrayList();
	}

}

@MyAnnotation(value = "at")
class Student extends Person {
	public void walk() {
		System.out.println("ѧ����·");
	}

	public void eat() {
		System.out.println("ѧ���Է�");
	}
}

class Person {
	String name;
	int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void walk() {
		System.out.println("��·");
	}

	@Deprecated
	public void eat() {
		System.out.println("�Է�");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}