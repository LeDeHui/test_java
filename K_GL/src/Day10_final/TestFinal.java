package Day10_final;

import javax.print.DocFlavor.STRING;

/*
 *final:���յ�,��������������,����,����
 *
 *1.final������		����಻�ܱ��̳�.��:String��,StringBuffer��,System��
 *
 *2.final���η���	���ܱ���д.��Object������getclass����
 *
 *3.final��������	�����Ծ�˵һ��������ϰ�߳����ô�д�ַ���ʾ
 *�˳��������︳ֵ�� 
 *	1�˳�������ʹ��Ĭ�ϳ�ʼ��
 *	2��ʽ�ĸ�ֵ,����飬������
 *������ static final���Ρ�ȫ�ֱ���
 *
 *>��finaly,finalise()����
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