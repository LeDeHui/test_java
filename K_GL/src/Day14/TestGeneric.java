package Day14;
/*
 * ���͵�ʹ��
 * 1.�ڼ�����ʹ�÷���
 * 2.�Զ��巺���࣬���ͽӿڣ����ͷ���
 * 3.������̳еĹ�ϵ
 * 4.ͨ���
 * 
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {
	/*
	 * ͨ�����ʹ��
	 * */
	@Test
	public void test7() {
		List<String> list  = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list1 = list;
		//���Զ�ȡ����Ϊͨ����ļ�����Ķ���
		Iterator<?> iterator =  list1.iterator();
		while (iterator.hasNext() ) {
			System.out.println(iterator.next());
		}
		// ������������Ϊͨ����ļ�����д�����  Ψһ���⣺null
//		list1.add("CC");
//		list1.add(123);
		list1.add(null);//
	}
	/*
	 * ͨ��� ? 
	 * List<A>,List<B>......����List<?>������
	 * 
	 * ? extends A :���Դ��A��������
	 * ? super A:���Դ��A���丸��
	 * */
	@Test
	public void test6() {
		List<?> list = null;
		List<Object> list1 = new   ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		list = list1;
		list = list2;
//		show(list);
		show(list1);
//		show(list2);
 		show1(list);
		show1(list1);
		show1(list2);
		
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3 = list4;
		List<? super Number> list5 = null;
		list5 = list1;
		
		
		
	}
	public void   show(List<Object> list   ) {
		// TODO Auto-generated method stub

	}
	public void   show1(List<?> list   ) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	// ������̳еĹ�ϵ
	/*
	 * ����A����B�����࣬��ôList<A>�Ͳ���List<B>���ӽӿ�
	 * 
	 */
	@Test
	public void test5() {
		Object obj = null;
		String str = "AA";
		obj = str;

		Object[] obj1 = null;
		String[] str1 = new String[] { "AA", "BB", "CC" };
		obj1 = str1;

		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
//		list= list1;
		// ����list = list1����
		// list.add(123);
		// String str = list1.get(0); // �������⣬���費����

	}

	// �Զ��巺�����ʹ��
	@Test
	public void test4() {
		// 1��ʵ�������������ʱ��ָ�����͵����͡�
		// ָ���󣬶�Ӧ������ʹ�÷��͵�λ�ã��ͱ��ʵ������ָ���ķ�������
		// 2��������Զ����˷����࣬����ʵ������û��ָ������ôĬ������ΪObject���

		Order<Boolean> order = new Order<>();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		order.add();
		List<Boolean> list = order.list;
		System.out.println(list);
//		��ͨ����������ͷ����ǣ�ָ�����ͷ���������
		Integer i = order.getE(34);
		double d = order.getE(2.3);

		Integer[] in = new Integer[] { 1, 2, 3 };
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = order.fromArrayToCollection(in, list2);
		System.out.println(list3);
		System.out.println("-----");

		SubOrder sub = new SubOrder();
		sub.setT(23);
		System.out.println(sub.getT());
		sub.list.add(123);
		sub.list.add(1231);
		List<Integer> l1 = sub.list;
		System.out.println(l1);
		l1.add(3);
		System.out.println(l1);

	}

	@Test
	public void test3() {
		Map<String, Integer> map = new HashMap<>();
		map.put("AA", 123);
		map.put("BB", 1234);
		map.put("CC", 56);
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for (Map.Entry<String, Integer> o : set) {
			System.out.println(o.getKey() + "--->" + o.getValue());
		}
	}

	// 2.�ڼ�����ʹ�÷���
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(89);
		list.add(87);
		list.add(67);
//		list.add(new String("AA"));
		for (int i = 0; i < list.size(); i++) {
			int score = (Integer) list.get(i);
			System.out.println(score);
		}

//		for (Integer  i :list) {
//			System.out.println(i);
//		}

	}

	// 1.�ڼ�����û��ʹ�÷��͵������
	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		// 1.û��ʹ�÷��ͣ��κ�Object��������Ķ��󶼿�����ӽ���
		// 2.ǿתΪint���ǣ����ܱ�java.lang.ClassCastException���쳣
		list.add(new String("AA"));
		for (int i = 0; i < list.size(); i++) {
			int score = (Integer) list.get(i);
			System.out.println(score);
		}

	}

}
