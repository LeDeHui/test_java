package Day12_2_Exception;

import java.io.IOException;
//子类重写的父类的方法，其抛出的异常类型只能是被重写的类型的子类或异常类型一样
public class TestOverride {

}

class A {
	public void method1() throws IOException {

	}
}

class B extends A {

	@Override
	public void method1() throws IOException {
		// TODO Auto-generated method stub
		super.method1();
	}

}