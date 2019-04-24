package Day13_1_Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.TreeSet;

import org.junit.Test;
/*
 * Collection接口   包List
 * 		|--List接口:存储有序的,可以重复的元素
 * 			|--ArrayList(主要的实现类)(Day12_4_List --> TestList)
 * 			|--LinkedList(对于频繁的插入删除操作,建议使用这个)
 * 			|--Vector(古老的实现类.线程安全的,不建议使用)
 * 		|--Set接口:存储无序的,不可以重复的元素
 * 			|--HashSet,LinkedHashSet,TreeSet
 * 	Map接口:存储  键-值对的数据
 * 		|--HashMap,LinkedHashMap,TreeMap,Hashtable(子类:Properties)
 * 
 * */

public class TestSet {

	/*
	 * TreeSet的定制排序:
	 * >compareTo()与hashcode（）已经equals（）三者保存一致
	 * 
	 */
	@Test
	public void testTreeSet2() {

		// 1.创建一个实现comparat0r接口的类对象
		Comparator com = new Comparator() {
//向Treeset中添加Customer类的对象，在此Comparator（）方法中，指明时按照Comparator的哪个属性排序的
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
		//2.将此对象作为形参传递给TreeSet的构造器中
		TreeSet set = new TreeSet (com);
		//3.向Treeset中添加comparator接口中的compare涉及的类对象
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
	 * TreeSet: 1.向TreeSet中添加的元素必须是同一类型的.
	 * 2.可以按照添加进集合中的元素的指定的顺序遍历，String，包装类默认按照从小到大的顺序遍历
	 * 3.当向Treeset中添加自定义类的对象时，有两种排序方法：自然排序 定制排序
	 * 4.自然排序：要求自定义类实现java.lang.comprable接口并重写其compareTo（Object o）方法
	 * 在此方法中，指明按照自定义的哪个属性进行排序
	 * 5.向Treeset中添加元素时，首先按照compareTo（）进行比较，一旦返回0，虽然仅是两个对象的此属性相同
	 * 但是程序会认为这两个对象时相同的，进而后一个不能添加进来 
	 * >compareTo()与hashcode（）已经equals（）三者保存一致
	 */
	@Test
	public void testTreeSet1() {
		Set set = new TreeSet();
//		set.add(123);			
//		set.add(456);
//		set.add("AA");
//		set.add("BB");
//		set.add(null);

		// 当Person类没有实现Comparable接口时，当向TreeSet中添加Person对象时，报ClassCastException错误
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
	 * LinkedHashSet:使用链表维护一个添加进集合中的顺序，导致当我们遍历LinkedHashSet（）集合元素时， 是按照添加进去的顺序遍历的
	 * 
	 * 
	 * LinkedHashSet插入性能略低于HashSet，但是在迭代访问Set里面的全部元素是有很好的性能
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
	 * set存储的元素是无序的，不可重复的 1.无序性：无序性 ！= 随机性 真正的无序性指的是元素在底层存储的位置是无需的
	 * 2.不可重复性：当向set中添加相同元素的时候，后面的这个元素不能被添加进去
	 * 
	 * 
	 * 说明：要求添加进Set中的元素所在的类，一定要重写hashCode() 和equals(Object obj)方法，进而保证Set中元素的不可重复性!
	 * 
	 * 
	 * Set中元素是如何存储的？使用哈希算法。 当向set中添加元素（对象）时，首先调用此对象的所在的类的 HashCode（）方法，
	 * 计算此对象的哈希值，此哈希值决定了此对象在set中的存储位置。 若此位置之前没有对象存储，则这个 对象就存储到此位置。
	 * 若此位置已有对象存储，再通过equals（）方法比较这两个对象是否相同， 相同，后一个对象不能在添加进来。 万一返回false呢，都存储（不建议）
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
