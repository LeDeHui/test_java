package Day13_3_Map;
/*
 * Collection接口    
 * 
 * 	Map接口:存储  键-值对的数据
 * 		|--HashMap :Map的主要实现类
 * 		|--LinkedHashMap：
 * 		|--TreeMap
 * 		|--Hashtable
			|--Properties 
 * 
 * 
 * */

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMap {
	
	/*
	 * Object put(Object key,Object values):向map中添加一个元素 
	 * Object remove(Object key)：按照指定的key删除此key-value
	 * void putALL (Map t):添加新的Map数据进入
	 * void clear()
	 * Object get(Object key)
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
		
		
		
		
	}

}
