package Day13_3_Map;
/*
 * Collection�ӿ�    
 * 
 * 	Map�ӿ�:�洢  ��-ֵ�Ե�����
 * 		|--HashMap :Map����Ҫʵ����
 * 		|--LinkedHashMap��
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
	 * Object put(Object key,Object values):��map�����һ��Ԫ�� 
	 * Object remove(Object key)������ָ����keyɾ����key-value
	 * void putALL (Map t):����µ�Map���ݽ���
	 * void clear()
	 * Object get(Object key)
	 * boolean containsKey(Object key)
	 * boolean containsValues(Object values)
	 * int size()  :���س���
	 * boolean isEmpty()
	 * boolean equals(Object obj)
	 * 
	 * 
	 * 
	 * HashMap:
	 * 1.Key����Ste����ŵģ������ظ���Value����collection����ŵģ����ظ�
	 * һ��Key-Value�ԣ���һ��Entry�����Ե�Entryʹ��Set��ŵģ������ظ���
	 * 2.��HashMap���Ԫ��ʱ�������Key���ڵ�equals�����������ж�����Key�Ƿ���ͬ��
	 * 		����ͬ>>>ֻ����ӽ� ����ӵ��Ǹ�Ԫ��
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
