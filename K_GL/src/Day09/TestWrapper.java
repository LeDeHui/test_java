package Day09;

import org.junit.jupiter.api.Test;

//��װ��  8�ֻ����������Ͷ�Ӧ���ࡣ���༴Ϊ��װ��
//������������  ��װ�� String������֮����໥װ��
public class TestWrapper {
	
	//�����������ͣ���װ����String��֮���ת��
	@Test
	public void test2() {
		//�����������ͣ���װ��-->String��
		//����STring ��ľ�̬����valueof��x������
		int i1 = 10;
		Integer i2 = i1;
		String str2 = String.valueOf(i2);
		System.out.println(str2);
		boolean b1 = true;
		String str3 = String.valueOf(b1);
		System.out.println(str3);
		
		//String�� --> �����������ͣ���װ��
		//���ð�װ���parseXXX��String Str������
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		Boolean b2 = Boolean.parseBoolean(str3);
		System.out.println(b2);
		
		
	}
	
	// ���������������װ���ת��
	@Test
	public void test1() {
		int i = 10;
		boolean b = true;
		// ������������--->��Ӧ�İ�װ�࣬���ð�װ��Ĺ�����
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
//		Integer i2=new Integer("123asd");
//		java.lang.NumberFormatException:
//		System.out.println(i2.toString());
		Float f = new Float("12.3f");
		System.out.println(f.toString());
		Boolean b1 = new Boolean(b);
		System.out.println(b1);
//		����boolean�����β�Ϊ true�Ƿ���true����������false
		Boolean b3 = new Boolean("trueadas");
		System.out.println(b3);
//		Boolean����Ϊnull
		ojbk o1 = new ojbk();
		System.out.println("$ " + o1.b);

		// ��װ��-->��Ӧ�Ļ�����������:���ð�װ���xxxvalue��������
		int i2 = i1.intValue();
		System.out.println(i2);
		float f2 = f.floatValue();
		System.out.println(f2);
		boolean b2 = b3.booleanValue();
		System.out.println(b2);
		// JDK 5.0�Ժ��Զ�װ��˲���
//		int i4 = 12;
//		Integer i3 = i4

		Integer i3 = 12;// �Զ�װ��
		int i5 = i3;// �Զ�����
	}
}

class ojbk {
	Boolean b;
}