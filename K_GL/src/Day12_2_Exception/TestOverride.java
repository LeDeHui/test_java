package Day12_2_Exception;

import java.io.IOException;
//������д�ĸ���ķ��������׳����쳣����ֻ���Ǳ���д�����͵�������쳣����һ��
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