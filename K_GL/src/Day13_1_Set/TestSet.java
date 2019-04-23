package Day13_1_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/*
 * Collection接口   包List
 * 		|--List接口:存储有序的,可以重复的元素
 * 			|--ArrayList(主要的实现类)(Day12_4_List --> TestList)
 * 			|--LinkedList(对于频繁的插入删除操作,建议使用这个)
 * 			|--Vector(古老的实现类.线程安全的,不建议使用)
 * 		|--Set接口:存储无序的,不可以重复的元素.set中常用的方法都是Collection下定义的
 * 			|--HashSet(主要实现类)
 * 			|--LinkedHashSet
 * 			|--TreeSet
 * */

import org.junit.Test;

public class TestSet {
	/*
	 * LinkedHashSet:使用链表维护一个添加进集合中的顺序，导致当我们遍历LinkedHashSet（）集合元素时，
	 * 是按照添加进去的顺序遍历的
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
	 * set存储的元素是无序的，不可重复的 
	 * 1.无序性：无序性 ！= 随机性 真正的无序性指的是元素在底层存储的位置是无需的
	 * 2.不可重复性：当向set中添加相同元素的时候，后面的这个元素不能被添加进去 
	 * 
	 * 
	 * 说明：要求添加进Set中的元素所在的类，一定要重写hashCode()
	 * 和equals(Object obj)方法，进而保证Set中元素的不可重复性!
	 * 
	 * 
	 * Set中元素是如何存储的？使用哈希算法。
	 * 当向set中添加元素（对象）时，首先调用此对象的所在的类的 HashCode（）方法，
	 * 计算此对象的哈希值，此哈希值决定了此对象在set中的存储位置。
	 * 若此位置之前没有对象存储，则这个 对象就存储到此位置。
	 * 若此位置已有对象存储，再通过equals（）方法比较这两个对象是否相同，
	 * 	相同，后一个对象不能在添加进来。
	 * 万一返回false呢，都存储（不建议）
	 * >要求hashcode（）方法要与equals（）方法一致
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
