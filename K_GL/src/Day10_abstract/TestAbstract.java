package Day10_abstract;

/*
 * abstract  抽象的，可以用来修饰类，方法
 * 1.abstract 修饰类，抽象类
 * 	1不可被实例化
 * 	2抽象类有构造器（凡是类都有构造器）
 * 	3抽象方法所在的类，一定是抽象类
 * 	4抽象类中可以没有抽象方法。
 *   >>>当我们设计一个类，不需要创建此类的实例时候，就可以考虑将其设置为抽象类，有子类实现这个类的抽象方法
 * 2abstract修饰方法，抽象方法
 * 	1格式：没有方法体，包括‘｛｝’ 如：public abstract void eat();
 * 	2抽象方法只保留方法的功能，而具体的执行交给继承抽象类的子类，由子类重写此抽象方法
 * 	3若子类继承抽象类，并重写了所有抽象方法，则此类就说一个‘实体类’，即，可以被实例化
 * 	4若子类没有承抽象类，没有重写所有抽象方法，意味这此类中仍有抽象方法，则此类必须声明为抽象类
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