package Day09;

import org.junit.jupiter.api.Test;

//��װ��  8�ֻ����������Ͷ�Ӧ���ࡣ���༴Ϊ��װ��
//������������  ��װ�� String������֮����໥װ��
public class TestWrapper {
	// ���������������װ���ת��
	@Test
	public void test1() {
		int i = 10;
		boolean b = true;
		// ������������--->��Ӧ�İ�װ�࣬���ð�װ��Ĺ�����
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		Float f = new Float("12.3f");
		System.out.println(f.toString());
		Boolean b1 = new Boolean(b);
		System.out.println(b1);
//		����boolean�����β�Ϊ true�Ƿ���true����������false
		Boolean b3 = new Boolean("trueadas");
		System.out.println(b3);
		
		ojbk o1 = new ojbk();
		System.out.println("$"+o1.b);
		
		//��װ��-->��Ӧ�Ļ�����������
	}
}

class ojbk{
	Boolean b;
}