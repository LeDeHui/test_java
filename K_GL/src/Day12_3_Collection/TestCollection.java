package Day12_3_Collection;
/*
 * 1.�洢������Կ��ǣ�	������	�ڼ���
 * 2.����洢������ص㣺Student[] stu = new Student[20];stu[0]= new Student;....
 *   >>>�׶ˣ���һ���������䳤�Ȳ��ɱ䡣  
 *   		  ����ʵ�������ŵĶ���ĸ����ǲ���֪��
 * 3.����
 * 
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;

public class TestCollection {
	@Test
	public void testCollection3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		System.out.println(coll);
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		System.out.println(coll1);
		// 10removeALL��Collection coll�����ӵ�ǰ������ɾ��������coll1�е�Ԫ�ء��
		coll.removeAll(coll1);
		System.out.println(coll);
		//equals��Object obj�����жϼ����е�����Ԫ���Ƿ���ȫ��ͬ
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add("AA1");
		System.out.println(coll1.equals(coll2));
		//12.
	}

	@Test
	public void testCollection2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		// Person p1 = new Person("MM",23);
		// coll.add(p1);
		coll.add(new Person("MM", 23));
		System.out.println(coll);
		// 6.contains(Object obj):�жϼ������Ƿ����ָ��objԪ�ء������������true������false
		// �жϵ����ݣ�����Ԫ�����ڵ�equals�������������ж�
		// ��ȷ��������뼯���е�Ԫ�����Զ���Ķ���Ҫ���Զ�����Ҫ��дequals��������
		boolean b1 = coll.contains(123);
		System.out.println(b1);
		// boolean b2 = coll.contains(p1 );
		boolean b2 = coll.add(new Person("MM", 23));
		System.out.println(b2);
		// 7.containsALL(Object obj)���жϵ�ǰ�������Ƿ����coll1�����Ե�Ԫ��
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		boolean b3 = coll.containsAll(coll1);
		System.out.println("#" + b3);
		coll1.add(456);
		// 8.retainAll(Collection coll):��ǰ������coll�Ĺ���Ԫ�أ����ظ���ǰ���ϡ�����
		coll.retainAll(coll1);
		System.out.println(coll);
		// 9.remove��Object obj��:ɾ�������е�objԪ�أ���ɾ���ɹ�����true�����򷵻�false
		boolean b4 = coll.remove("BB");
		System.out.println(b4);

	}

	@Test
	public void testCollection1() {
		Collection coll = new ArrayList();
		// 1.size():���ؼ�����Ԫ�صĸ���
		System.out.println(coll.size());
		// 2.add(Object obj): �򼯺������һ��Ԫ�ء�
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		System.out.println(coll.size());
		// 3.addALL(Collection coll):���β�coll�а���������Ԫ����ӵ���ǰ������
		Collection coll1 = Arrays.asList(1, 2, 3, "SS");
		coll.addAll(coll1);
		System.out.println(coll.size());
		// 5.�鿴����Ԫ��
		System.out.println(coll.toString());
		// 4.isEmpty():�жϼ����Ƿ�Ϊ��
		System.out.println(coll.isEmpty());
		// 5.clear()����ռ���Ԫ��
		coll.clear();
		System.out.println(coll.isEmpty());
	}
}
