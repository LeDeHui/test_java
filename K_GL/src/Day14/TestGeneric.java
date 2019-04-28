package Day14;
/*
 * 泛型的使用
 * 1.在集合中使用泛型
 * 2.自定义泛型类，泛型接口，泛型方法
 * 3.泛型与继承的关系
 * 4.通配符
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

	// 自定义泛型类的使用
	@Test
	public void test4() {
		// 1当实例化泛型类对象时，指明泛型的类型。
		// 指明后，对应的类中使用泛型的位置，就变成实例化中指定的泛型类型
		// 2如果我们自定义了泛型类，但是实例化中没有指明，那么默认类型为Object类的

		Order<Boolean> order = new Order<>();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		order.add();
		List<Boolean> list = order.list;
		System.out.println(list);
//		当通过对象调泛型方法是，指明泛型方法的类型
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

	// 2.在集合中使用泛型
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

	// 1.在集合中没有使用泛型的情况下
	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		// 1.没有使用泛型，任何Object及其子类的对象都可以添加进来
		// 2.强转为int型是，可能报java.lang.ClassCastException的异常
		list.add(new String("AA"));
		for (int i = 0; i < list.size(); i++) {
			int score = (Integer) list.get(i);
			System.out.println(score);
		}

	}

}
