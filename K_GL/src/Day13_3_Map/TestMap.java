package Day13_3_Map;
/*
 * Collection接口    
 * 
 * 	Map接口:存储  键-值对的数据
 * 		|--HashMap :Map的主要实现类
 * 		|--LinkedHashMap：使用链表维护添加进map的顺序，故遍历map时，是按照添加顺序遍历
 * 		|--TreeMap：按照添加进map的元素的key的指定属性进行排序。要求：key是同一个类的对象！
 * 					自然排序  VS  定制排序
 * 		|--Hashtable
			|--Properties 
 * 
 * 
 * */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TestMap {
	/*TreeMap
	 * 自然排序  VS  定制排序
	 * */
	@Test
	public void test4() {
		Map map = new TreeMap();
		map.put("AA", 123);
		map.put("BB", 456); 
		map.put(123,"CC");
		map.put(null, null);
		Set set1 = map.keySet();
		for (Object obj:set1) {
			System.out.println(obj +"---->" + map.get(obj));
		}
	}
	
	/*
	 * 
	 * LinkedHashMap
	 * 
	 * */
	@Test
	public void test3() {
		Map map = new LinkedHashMap () ;
		 
		
	}
	/*
	 * 如何遍历Map：
	 * Set keySet()
	 * collection values()
	 * Set entrySet()
	 * 
	 * */
	@Test
	public void test2() {
		Map map = new HashMap ();
		map.put("AA", 123);
		map.put("BB", 456); 
		map.put(123,"CC");
		map.put(null, null);
		
		//1.遍历key集
		Set set = map.keySet();
		for (Object obj:set) {
			System.out.println(obj);
		}
		System.out.println();
		//2.遍历values集
		Collection  ValueSource  = map.values();
		Iterator iterator = ValueSource.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		//3.如何遍历entry（key-value对）
//		方式1
		Set set1 = map.keySet();
		for (Object obj:set1) {
			System.out.println(obj +"---->" + map.get(obj));
		}
//		方式2
		 Set set2 = map.entrySet();
		 for (Object obj:set2) {
			 Map.Entry entry  = (Map.Entry)obj;
			 System.out.println(entry);
		 }
		
		
	}
	
	/*
	 * Object put(Object key,Object values):向map中添加一个元素 
	 * Object remove(Object key)：按照指定的key删除此key-value
	 * void putALL (Map t):添加新的Map数据进入
	 * void clear() :清空
	 * Object get(Object key)
	 *：获取指定key的value值.若无此key返回null
	 * boolean containsKey(Object key)
	 * boolean containsValues(Object values)
	 * int size()  :返回长度
	 * boolean isEmpty()
	 * boolean equals(Object obj)
	 * 
	 * 
	 * 
	 * HashMap:
	 * 1.Key是用Ste来存放的，不可重复。Value是用collection来存放的，可重复
	 * 一个Key-Value对，是一个Entry，所以的Entry使用Set存放的，不可重复。
	 * 2.向HashMap添加元素时，会调用Key所在的equals（）方法，判断两个Key是否相同。
	 * 		若相同>>>只能添加进 后添加的那个元素
	 * 
	 * */
	@Test
	public void test1() {
		Map map = new HashMap ();
		map.put("AA", 123);
		map.put("BB", 456);
//		map.put("BB", 456);
		map.put(123,"CC");
		map.put(null, null);
		System.out.println(map.size());//4
		map.remove("BB");
		System.out.println(map);
		
		System.out.println(map.get(123));
		
		
		
		
	}

}
