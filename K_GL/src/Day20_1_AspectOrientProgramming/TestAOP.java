package Day20_1_AspectOrientProgramming;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();

	void fly();
}

class SuperMan implements Human {

	@Override
	public void info() {
		System.out.println("我是超人!我怕谁");
	}

	@Override
	public void fly() {
		System.out.println("I believe I can fly!");
	}

}

class HumanUtil {
	public void method1() {
		System.out.println("=====方法一=====");

	}

	public void method2() {
		System.out.println("=====方法二=====");

	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public void setObject(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumanUtil humanUtil = new HumanUtil();
		humanUtil.method1();
		Object returnVal = method.invoke(obj, args);
		humanUtil.method2();
		return returnVal;
	}

}

class MyProxy {
	// 动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}
}

public class TestAOP {
	public static void main(String[] args) {
		SuperMan man = new SuperMan();//
		
	}

}
