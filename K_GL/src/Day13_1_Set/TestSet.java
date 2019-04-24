package Day13_1_Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.TreeSet;

import org.junit.Test;
/*
 * Collection�ӿ�   ��List
 * 		|--List�ӿ�:�洢�����,�����ظ���Ԫ��
 * 			|--ArrayList(��Ҫ��ʵ����)(Day12_4_List --> TestList)
 * 			|--LinkedList(����Ƶ���Ĳ���ɾ������,����ʹ�����)
 * 			|--Vector(���ϵ�ʵ����.�̰߳�ȫ��,������ʹ��)
 * 		|--Set�ӿ�:�洢�����,�������ظ���Ԫ��
 * 			|--HashSet,LinkedHashSet,TreeSet
 * 	Map�ӿ�:�洢  ��-ֵ�Ե�����
 * 		|--HashMap,LinkedHashMap,TreeMap,Hashtable(����:Properties)
 * 
 * */

public class TestSet {

	/*
	 * TreeSet�Ķ�������:
	 * >compareTo()��hashcode�����Ѿ�equals�������߱���һ��
	 * 
	 */
	@Test
	public void testTreeSet2() {

		// 1.����һ��ʵ��comparat0r�ӿڵ������
		Comparator com = new Comparator() {
//��Treeset�����Customer��Ķ����ڴ�Comparator���������У�ָ��ʱ����Comparator���ĸ����������
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if (o1 instanceof Customer && o2 instanceof Customer) {
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i =  c1.getId().compareTo(c2.getId());
					if(i==0) {
						return c1.getNameString().compareTo(c2.getNameString());
					}else {
						return i;
					}
				}
				return 0;
			}

		};
		//2.���˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�������
		TreeSet set = new TreeSet (com);
		//3.��Treeset�����comparator�ӿ��е�compare�漰�������
		set.add(new Customer("AA", 1003 )) ;
		set.add(new Customer("BB", 1002 )) ;	
		set.add(new Customer("CC", 1001 )) ;	
		set.add(new Customer("DD", 1004 )) ;	
		set.add(new Customer("EE", 1007 )) ;	
		set.add(new Customer("FF", 1007)) ;	
		for (Object str : set) {
			System.out.println(str);
		}

		
	}

	/*
	 * TreeSet: 1.��TreeSet����ӵ�Ԫ�ر�����ͬһ���͵�.
	 * 2.���԰�����ӽ������е�Ԫ�ص�ָ����˳�������String����װ��Ĭ�ϰ��մ�С�����˳�����
	 * 3.����Treeset������Զ�����Ķ���ʱ�����������򷽷�����Ȼ���� ��������
	 * 4.��Ȼ����Ҫ���Զ�����ʵ��java.lang.comprable�ӿڲ���д��compareTo��Object o������
	 * �ڴ˷����У�ָ�������Զ�����ĸ����Խ�������
	 * 5.��Treeset�����Ԫ��ʱ�����Ȱ���compareTo�������бȽϣ�һ������0����Ȼ������������Ĵ�������ͬ
	 * ���ǳ������Ϊ����������ʱ��ͬ�ģ�������һ��������ӽ��� 
	 * >compareTo()��hashcode�����Ѿ�equals�������߱���һ��
	 */
	@Test
	public void testTreeSet1() {
		Set set = new TreeSet();
//		set.add(123);			
//		set.add(456);
//		set.add("AA");
//		set.add("BB");
//		set.add(null);

		// ��Person��û��ʵ��Comparable�ӿ�ʱ������TreeSet�����Person����ʱ����ClassCastException����
		set.add(new Person("aa", 23));
		set.add(new Person("bb", 120));
		set.add(new Person("cc", 25));
		set.add(new Person("dd", 29));
		set.add(new Person("ee", 27));
		set.add(new Person("kk", 120));
		for (Object str : set) {
			System.out.println(str);
		}

	}

	@Test
	public void testTreeSet10() {
		Set set = new TreeSet();
		set.add("GG");
		set.add("MM");
		set.add("AA");
		set.add("BB");
		for (Object str : set) {
			System.out.println(str);
		}
		Set set1 = new TreeSet();
		set1.add(1);
		set1.add(2);
		set1.add(5);
		set1.add(3);
		for (Object str : set1) {
			System.out.println(str);
		}
	}

	/*
	 * LinkedHashSet:ʹ������ά��һ����ӽ������е�˳�򣬵��µ����Ǳ���LinkedHashSet��������Ԫ��ʱ�� �ǰ�����ӽ�ȥ��˳�������
	 * 
	 * 
	 * LinkedHashSet���������Ե���HashSet�������ڵ�������Set�����ȫ��Ԫ�����кܺõ�����
	 * 
	 */
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
	 * set�洢��Ԫ��������ģ������ظ��� 1.�����ԣ������� ��= ����� ������������ָ����Ԫ���ڵײ�洢��λ���������
	 * 2.�����ظ��ԣ�����set�������ͬԪ�ص�ʱ�򣬺�������Ԫ�ز��ܱ���ӽ�ȥ
	 * 
	 * 
	 * ˵����Ҫ����ӽ�Set�е�Ԫ�����ڵ��࣬һ��Ҫ��дhashCode() ��equals(Object obj)������������֤Set��Ԫ�صĲ����ظ���!
	 * 
	 * 
	 * Set��Ԫ������δ洢�ģ�ʹ�ù�ϣ�㷨�� ����set�����Ԫ�أ�����ʱ�����ȵ��ô˶�������ڵ���� HashCode����������
	 * ����˶���Ĺ�ϣֵ���˹�ϣֵ�����˴˶�����set�еĴ洢λ�á� ����λ��֮ǰû�ж���洢������� ����ʹ洢����λ�á�
	 * ����λ�����ж���洢����ͨ��equals���������Ƚ������������Ƿ���ͬ�� ��ͬ����һ������������ӽ����� ��һ����false�أ����洢�������飩
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
