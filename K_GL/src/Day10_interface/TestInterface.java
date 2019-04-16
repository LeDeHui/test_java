package Day10_interface;

/*
 *接口  interface   是与类并行的一个概念 
 *1.接口可以看成一个特殊的抽象类.是常量与抽象方法烦人一个集合.不能包含变量,一般的方法
 *2.接口是没有构造器的.不能被实例化
 *3.接口定义的就说一种功能,此功能可以被类所实现(implements).
 *		比如class BB implements AA, CC 
 *			class BB extends DD implements AA, CC
 *4.实现接口的类,必须重写其中的所有抽象方法,方可实例化.若没有重所有的抽象方法,这此类仍为抽象类
 *5.类可以实现多个接口  ----Java中的类的继承是单继承.
 *6.接口与接口之间也是继承的关系,而且可以实现多继承
 *>>5.6描述的是Java中的继承特点
 *7.接口与具体的实现类之间也存在多态性
 *
 * 
 * **/
public class TestInterface {

}

interface AA {
	// 常量,所有的常量都用public static final 修饰
	final static public int I = 12;
	public static final boolean FLAG = false;
	int I1 = 9;
	// 不能定义变量

	// 抽象方法 所有抽象方法都有public abstract修饰
	public abstract void method1();

	public abstract void method2();

	void method3();

}

class DD {

}

interface CC {
	public abstract void method4();
}

class BB extends DD implements AA, CC {
	public void method1() {
	};

	public void method2() {
	};

	public void method3() {
	};

	public void method4() {
	};
}


interface JJ extends AA {
	void methom5();

}
//接口之间仍为继承关系....可以多继承
class GG implements JJ ,CC{
	public void methom5() {
	};

	public void method1() {
	};

	public void method2() {
	};

	public void method3() {
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	};
}
