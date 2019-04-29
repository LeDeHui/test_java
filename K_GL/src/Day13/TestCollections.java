package Day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * 操作Collection以及Map的工具类 Collections:
 * 
 * 
 * 
 * 
 * 
 * */
public class TestCollections {
	/*
	 * Object max(Collection):根据元素的自然排序顺序,返回给定集合中的最大元素
	 * Object max(Collection.Comparator):根据Comparator指定的顺序,返回给定集合中的
	 * Object min(Collection)
	 * Object min(Collection.Comparator)
	 * int frequency(Collection  ,object):返回指定几个中指定元素出现的次数
	 * void copy(List dest,List src):将src中的内容复制到dest中
	 * boolean replaceAll(List list,Object lodVal,Object newVal):使用新值替换List中的旧值
	 * 
	 * */
	@Test
	public void testCollections2() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		list.add(456);
		Object object = Collections.max(list);
		System.out.println(object);
		System.out.println(Collections.frequency(list, 456));
//		List list1 = new ArrayList();错误是实现方式
		List list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		//线程安全的:通过如下方法保证list的线程安全  list2为线程安全的
		List list2 = Collections.synchronizedList(list);
		System.out.println(list2);
	}
	/*
	 * reverse(List):反转List中元素的顺序
	 * shuffle(List):对List集合元素进行随机排序
	 * sort(List):根据元素的自然顺序对指定的List集合元素按升序排序
	 * sort(List.Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
	 * swap(List,int,int):将指定List集合中的I处元素和J处元素进行交换
	 * 
	 * */
	@Test
	public void testCollections1() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.swap(list, 0, 2);
		System.out.println(list);
	}
}
