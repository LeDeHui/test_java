package Day10_interface;

/*
 *�ӿ�  interface   �����ಢ�е�һ������ 
 *1.�ӿڿ��Կ���һ������ĳ�����.�ǳ�������󷽷�����һ������.���ܰ�������,һ��ķ���
 *2.�ӿ���û�й�������.���ܱ�ʵ����
 *3.�ӿڶ���ľ�˵һ�ֹ���,�˹��ܿ��Ա�����ʵ��(implements).
 *		����class BB implements AA, CC 
 *			class BB extends DD implements AA, CC
 *4.ʵ�ֽӿڵ���,������д���е����г��󷽷�,����ʵ����.��û�������еĳ��󷽷�,�������Ϊ������
 *5.�����ʵ�ֶ���ӿ�  ----Java�е���ļ̳��ǵ��̳�.
 *6.�ӿ���ӿ�֮��Ҳ�Ǽ̳еĹ�ϵ,���ҿ���ʵ�ֶ�̳�
 *>>5.6��������Java�еļ̳��ص�
 *
 * 
 * **/
public class TestInterface {

}

interface AA {
	// ����,���еĳ�������public static final ����
	final static public int I = 12;
	public static final boolean FLAG = false;
	int I1 = 9;
	// ���ܶ������

	// ���󷽷� ���г��󷽷�����public abstract����
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
//�ӿ�֮����Ϊ�̳й�ϵ....���Զ�̳�
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
