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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {

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
		double d=order.getE(2.3);
		
		Integer[] in  = new Integer[]{1,2,3};
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = order.fromArrayToCollection(in,list2);
		System.out.println(list3);
		System.out.println("-----");
		
		SubOrder sub = new SubOrder();
		sub.setT(23); 
		System.out.println(sub.getT());
		sub.list.add(123);
		sub.list.add(1231);
		List<Integer> l1 =  sub.list;
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
