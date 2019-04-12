package Day09_1;

/*
 * static,静态的，可以用来修饰属性，方法，代码块，内部类
 * 
 * static 修饰属性(类变量):
 * 1.由类创建的所有对象,都公用这一个属性
 * 2.当其中一个对象对此类进行修改,会导致其他属性对象对此属性的一个调用.vs实例变量（非static修饰的属性，各自对象拥有一套副本）
 * 3.类变量是随着类的加载而加载的,而且是独一份
 * 4.静态的变了可以直接通过  类.类变量 的形式来调用
 * 5.类变量的加载是要早于对象的,所以当有对象以后，可以  对象.类变量 使用，但是 类.实例变量 是不行的
 * 6.类变量存在于静态域中
 * 
 * 
 * static 修饰方法-类方法
 * 1.随着类的加载而加载，在内存中也是独一份
 * 2.可以直接通过 '类.类方法' 的方法调用.
 * 3.内部可以调用静态的属性或方法,而不能调用非静态的属性方法.反正,非静态的方法可以调用静态的属性或方法
 * 		>>>静态的方法内不可以有this关键字
 *      静态的结构(static的属性,方法,代码块,内部类)的生命周期要早于非静态的结构,同时被回收也要晚于非静态的结构
 * 
 * 
 * 
 * 
 * 
 * */
public class TestSprtsMan {
	public static void main(String[] args) {
		SportMan s1 = new SportMan("勒德辉", 26);
		SportMan s2 = new SportMan("勒德煌", 15);
		s1.nation = "china";
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(SportMan.nation);
//		SportMan.shou1();
		SportMan.show2();
	}
}

class SportMan {
	// 实例变量 随着对象的创建而被加载的
	String name;
	int age;
	// 类变量 随着类的加载而加载
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
		System.out.println("我是一个来自中国的运动员");
	}

	static public void show2() {
		System.out.println("nation:" + nation);
		info();
//		System.out.println("age :" + age);
		System.out.println("我是一个来自中国的运动员");
	}

	public static void info() {
		System.out.println("我是静态的方法");
	}
}