package Day12_3_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class TestIterator {
	//������
	@Test
	public void testFor3() {
		String[] str = new String[] {"aa","bb","cc"};
		for (String s:str) {
			s  =  "MM ";//�˴���s���¶���ľֲ�����.��ֵ�޸Ĳ�Ӱ��str��ֵ
			System.out.println(s);
		}
		for (String s:str) {
			System.out.println(s);//aabbcc
		}
	}
	@Test
	public void testFor2() {
		String[] str = new String[] {"aa","bb","cc"};
		for (int i = 0;i<str.length;i++) {
			str[i] = i +" ";
		}
		for (String s:str) {
			System.out.println(s);//012
		}
	}
	//*********************************************
	//ʹ����ǿforѭ��ʵ������ı���
	@Test
	public void testFor1() {
		String[] str = new String[] {"aa","bb","cc"};
		for (String  s:str) {
			System.out.println(s);
		}
	}
	
	
	//ʹ����ǿforѭ��ʵ�ּ��ϱ���
	@Test
	public void testFor() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		
		for(Object  i:coll )
		{
			System.out.println(i);
		}
	}
	
	
	//�����д��
	@Test
	public void test2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		Iterator i1= coll.iterator();
		while ((i1.next())!=null) {
			//java.util.NoSuchElementException
			System.out.println(i1.next());
		}
	}
	//��ȷ��д��:ʹ�õ�����Iteratorʵ�ּ��ϵı���
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		Iterator i1= coll.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next());
		}
	}

}
