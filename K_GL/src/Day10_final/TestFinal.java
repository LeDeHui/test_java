package Day10_final;

import javax.print.DocFlavor.STRING;

/*
 *final:最终的,可以用来修饰类,属性,方法
 *
 *1.final修饰类		这个类不能被继承.如:String类,StringBuffer类,System类
 *
 *2.final修饰方法	不能被重写.如Object（）的getclass（）
 *
 *3.final修饰属性	此属性就说一个常量。习惯常量用大写字符表示
 *此常量在哪里赋值： 
 *	1此常量不能使用默认初始化
 *	2显式的赋值,代码块，构造器
 *变量用 static final修饰。全局变量
 *
 *>与finaly,finalise()区分
 *
 **/
public class TestFinal {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.getClass()  + " "+Math.PI);
	}

}

class E {

	final int I = 66;
	final double pi;
	final double pi1;
	{
		pi = 3.14;
	}
	public E() {
		pi1 = 3.142;
	}
	public E(double d) {
		this.pi1 = d;
	}

}

//class SubString extends String{
//	
//}

final class A {

}

//class b extends a {
//
//}
class C {
	final public void method1() {
		System.out.println("final");
	}
}

class D extends C {
//	public void method1() {
//		System.out.println("final1");
//	}
}