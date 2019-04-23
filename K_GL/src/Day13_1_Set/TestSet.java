package Day13_1_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/*
 * Collection�ӿ�   ��List
 * 		|--List�ӿ�:�洢�����,�����ظ���Ԫ��
 * 			|--ArrayList(��Ҫ��ʵ����)(Day12_4_List --> TestList)
 * 			|--LinkedList(����Ƶ���Ĳ���ɾ������,����ʹ�����)
 * 			|--Vector(���ϵ�ʵ����.�̰߳�ȫ��,������ʹ��)
 * 		|--Set�ӿ�:�洢�����,�������ظ���Ԫ��.set�г��õķ�������Collection�¶����
 * 			|--HashSet(��Ҫʵ����)
 * 			|--LinkedHashSet
 * 			|--TreeSet
 * */

import org.junit.Test;

public class TestSet {
	/*
	 * LinkedHashSet:ʹ������ά��һ����ӽ������е�˳�򣬵��µ����Ǳ���LinkedHashSet��������Ԫ��ʱ��
	 * �ǰ�����ӽ�ȥ��˳�������
	 * */
	@Test
	public void testLinkedHashSet() {
		Set set = new LinkedHashSet();
		set.add(123);		
		set.add("AA");
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add(null);
		
		Iterator inerator = set.iterator();
				while (inerator.hasNext()) {
					System.out.println(inerator.next());
					
				}
		}

	/*
	 * set�洢��Ԫ��������ģ������ظ��� 
	 * 1.�����ԣ������� ��= ����� ������������ָ����Ԫ���ڵײ�洢��λ���������
	 * 2.�����ظ��ԣ�����set�������ͬԪ�ص�ʱ�򣬺�������Ԫ�ز��ܱ���ӽ�ȥ 
	 * 
	 * 
	 * ˵����Ҫ����ӽ�Set�е�Ԫ�����ڵ��࣬һ��Ҫ��дhashCode()
	 * ��equals(Object obj)������������֤Set��Ԫ�صĲ����ظ���!
	 * 
	 * 
	 * Set��Ԫ������δ洢�ģ�ʹ�ù�ϣ�㷨��
	 * ����set�����Ԫ�أ�����ʱ�����ȵ��ô˶�������ڵ���� HashCode����������
	 * ����˶���Ĺ�ϣֵ���˹�ϣֵ�����˴˶�����set�еĴ洢λ�á�
	 * ����λ��֮ǰû�ж���洢������� ����ʹ洢����λ�á�
	 * ����λ�����ж���洢����ͨ��equals���������Ƚ������������Ƿ���ͬ��
	 * 	��ͬ����һ������������ӽ�����
	 * ��һ����false�أ����洢�������飩
	 * >Ҫ��hashcode��������Ҫ��equals��������һ��
	 * 
	 */
	@Test
	public void testHashSet() {
		Set set = new HashSet();
		set.add(123);		
		set.add("AA");
		set.add("AA");
		set.add(456);
		set.add("BB");
		set.add(null);
		Person p1 = new Person("GG", 23);
		Person p2 = new Person("MM", 21);
		Person p3 = new Person("GG", 23);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println(set.size());
		System.out.println(set);
	}
}
