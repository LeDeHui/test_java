package Day11_InnerClass;

import Day11_InnerClass.Person.Bord;

//内部类
/*
 * 类的第五个成员：内部类
 * 1.相当于说，我们可以在类的内部再定义类。外面的叫外部类，内部的叫内部类
 * 2.内部类的分类：
 * 		1）成员内部类：声明在类内部且方法外
 * 		2）局部内部类：声明在类内部且方法里
 * 3.成员内部类：
 * 		3.1是外部类的一个成员：
 * 			1）可以有修饰符（4个）
 * 			2）static  final  
 * 			3）可以调用外部类的属性方法
 * 		3.2具体类的特点：
 * 			1）abstract
 * 			2）还可以在其内部定义属性，方法,构造器
 * 4.局部内部类：
 * 5.关于内部类，大致掌握三点：
 * 		1）如何创建成员内部类对象(如创建Bird（） 和Dog（） 的对象)
 * 		2）如何区分调用外部类，内部类的变量(尤其是变量重名时)
 * 		3）局部内部类的使用   (见TestInnerClass1.java)
 * 
 * */
public class TestInnerClass {
	public static void main(String[] args) {
		// 创建静态内部类的对象，可以直接通过外部类调用静态内部类的构造器
		Person.Dog d = new Person.Dog();
		// 创建非静态的内部类的对象：必须先创建外部类的对象，通过外部类的对象调用内部类的构造器
		Person p = new Person();
		Person.Bord b = p.new Bord();
		b.info();
		b.setName("王五");

	}

}

class Person {
	String name = "张三";
	int age;

	// 成员内部类（非静态）
	class Bord {
		String name = "李四";
		int id;

		public Bord() {

		}

//2）如何区分调用外部类，内部类的变量(尤其是变量重名时)
		public void setName(String name) {
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Person.this.name);
		}

		public void info() {
			show();
		}
	}

	// 成员内部类（静态）
	static class Dog {

	}

	public void method1() {
		class A {

		}
	}

	private void show() {
		System.out.println("我是show一下");
	}
}
