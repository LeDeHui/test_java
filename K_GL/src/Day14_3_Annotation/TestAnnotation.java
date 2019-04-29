package Day14_3_Annotation;

import java.util.List;
import java.util.ArrayList;

/*
 * 
 * 注解：
 * 1.JDK提供的常用的注解
	 * 	@Override：限定重写父类方法，该注解只能用于方法
	 * 	@Deprecated:用于表示某个程序元素（类，方法等）一过时
	 * 	@SuppressWarnings:抑制编译器警告
 * 2.如何自定义注解： --> MyAnnotation
 * 
 * 3.元注解
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
		System.out.println("学生走路");
	}

	public void eat() {
		System.out.println("学生吃饭");
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
		System.out.println("走路");
	}

	@Deprecated
	public void eat() {
		System.out.println("吃饭");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}