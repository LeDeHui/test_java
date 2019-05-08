package Day19_3_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//��̬�����ʹ��

interface Subject {
	void action();
}

//��������
class RealSubject implements Subject {

	@Override
	public void action() {
		System.out.println("----���Ǳ�������----");
	}
}

class MyInvocationHandler implements InvocationHandler {

	Object object;// ʵ���˽ӿڵı�������Ķ��������

	// 1.����������Ķ���ʵ����
	// 2.����һ��������Ķ���
	public Object blind(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

//��ͨ��������Ķ�����Ա���д�ķ����ĵ���ʱ,����ת��Ϊ����ѡ��invoke�ķ����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// method�����ķ���ֵʱreturnVal
		Object returnVal = method.invoke(object, args);
		return returnVal;
	}
}

public class TestProxy {
	public static void main(String[] args) {

		//2.����һ��ʵ����InvocationHandler���˵���Ķ���
		MyInvocationHandler handler = new MyInvocationHandler();
		//1.��������Ķ���
		RealSubject realSubject = new RealSubject();
		//3.����blind()����,��̬�ķ���һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ�����Ķ���
		Object object = handler.blind(realSubject);
		Subject subject = (Subject)object;//subject��˵������Ķ���
		subject.action();//ת����InvocationHandler�ӿڵ�ʵ�����invoke()�����ĵ���
		
		
		//�پ�һ��
		NikeClothFactory nike  = new NikeClothFactory();
		ClothFactory proxyCloth = (ClothFactory) handler.blind(nike);
		proxyCloth.productCloth();
	}
}
