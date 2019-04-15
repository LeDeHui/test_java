package Day10;

/* 设计模式:设计模式是在大量实践中总结和理论化之后优选的代码结构,编程风格,以及解决问题的思考方式 
 * 23种设计模式.
 * 
 * 	单例设计模式
 * 1.解决的问题:使得一个类只能够创建一个对象
 * 2.如何实现?
 *		1.私有化构造器,使得在类的外部不能调用此构造器
		2.在类的内部创建一个类的实例
		3.私有化此对象,通过公共的方法来调用
 		4.此公共的方法,只能通过类来调用,因此设置为static的,同时,类的实例也必须是static申明的
 * 
 * 
 * 
 * */
//饿汉式  
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}

}

class Singleton {
	// 1.私有化构造器,使得在类的外部不能调用此构造器
	private Singleton() {

	}

	// 2.在类的内部创建一个类的实例
	private static Singleton instance = new Singleton();

	// 3.私有化此对象,通过公共的方法来调用
	// 4.此公共的方法,只能通过类来调用,因此设置为static的,同时,类的实例也必须是static申明的
	public static Singleton getInstance() {
		return instance;
	}

}
/*
 * class Singleton {
	// 1.私有化构造器,使得在类的外部不能调用此构造器
	private Singleton() {

	}

	// 2.在类的内部创建一个类的实例
	private static Singleton instance = null;
	static {
	instance = new Singleton();
	}

	// 3.私有化此对象,通过公共的方法来调用
	// 4.此公共的方法,只能通过类来调用,因此设置为static的,同时,类的实例也必须是static申明的
	public static Singleton getInstance() {
		return instance;
	}

}*/
 