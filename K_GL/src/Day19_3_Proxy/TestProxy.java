package Day19_3_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用

interface Subject {
	void action();
}

//被代理类
class RealSubject implements Subject {

	@Override
	public void action() {
		System.out.println("----我是被代理类----");
	}
}

class MyInvocationHandler implements InvocationHandler {

	Object object;// 实现了接口的被代理类的对象的声明

	// 1.给被代理类的对象实例化
	// 2.返回一个代理类的对象
	public Object blind(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

//当通过代理类的对象发起对被重写的方法的调用时,都会转化为对入选的invoke的方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// method方法的返回值时returnVal
		Object returnVal = method.invoke(object, args);
		return returnVal;
	}
}

public class TestProxy {
	public static void main(String[] args) {

		//2.创建一个实现了InvocationHandler结了的类的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		//1.被代理类的对象
		RealSubject realSubject = new RealSubject();
		//3.调用blind()方法,动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象
		Object object = handler.blind(realSubject);
		Subject subject = (Subject)object;//subject就说代理类的对象
		subject.action();//转到对InvocationHandler接口的实现类的invoke()方法的调用
		
		
		//再举一例
		NikeClothFactory nike  = new NikeClothFactory();
		ClothFactory proxyCloth = (ClothFactory) handler.blind(nike);
		proxyCloth.productCloth();
	}
}
