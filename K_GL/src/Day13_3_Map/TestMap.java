package Day13_3_Map;
/*
 * Collection�ӿ�    
 * 
 * 	Map�ӿ�:�洢  ��-ֵ�Ե�����
 * 		|--HashMap :Map����Ҫʵ����
 * 		|--LinkedHashMap��ʹ������ά����ӽ�map��˳�򣬹ʱ���mapʱ���ǰ������˳�����
 * 		|--TreeMap��������ӽ�map��Ԫ�ص�key��ָ�����Խ�������Ҫ��key��ͬһ����Ķ���
 * 					��Ȼ����  VS  ��������
 * 		|--Hashtable:���ϵ�ʵ����,�̰߳�ȫ,������ʹ��.
			|--Properties :���������������ļ�,����ֵ����String���͵�
 * 
 * 
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.sql.rowset.JdbcRowSet;

import org.junit.Test;

public class TestMap {

	//ʹ��Properties���������ļ�
	@Test
	public void test5() throws FileNotFoundException, IOException {
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdbc.propertides")));
		
		String user  = pros.getProperty("user");
		System.out.println(user);
		String password = pros.getProperty("password");
		System.out.println(password);
		
	}

	/*
	 * TreeMap ��Ȼ���� VS ��������
	 */
	@Test
	public void test4() {
		Map map = new TreeMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put(123, "CC");
		map.put(null, null);
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "---->" + map.get(obj));
		}
	}

	/*
	 * 
	 * LinkedHashMap
	 * 
	 */
	@Test
	public void test3() {
		Map map = new LinkedHashMap();

	}

	/*
	 * ��α���Map�� Set keySet() collection values() Set entrySet()
	 * 
	 */
	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put(123, "CC");
		map.put(null, null);

		// 1.����key��
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		System.out.println();
		// 2.����values��
		Collection ValueSource = map.values();
		Iterator iterator = ValueSource.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		// 3.��α���entry��key-value�ԣ�
//		��ʽ1
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + "---->" + map.get(obj));
		}
//		��ʽ2
		Set set2 = map.entrySet();
		for (Object obj : set2) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry);
		}

	}

	/*
	 * Object put(Object key,Object values):��map�����һ��Ԫ�� Object remove(Object
	 * key)������ָ����keyɾ����key-value void putALL (Map t):����µ�Map���ݽ��� void clear() :���
	 * Object get(Object key) ����ȡָ��key��valueֵ.���޴�key����null boolean
	 * containsKey(Object key) boolean containsValues(Object values) int size()
	 * :���س��� boolean isEmpty() boolean equals(Object obj)
	 * 
	 * 
	 * 
	 * HashMap: 1.Key����Ste����ŵģ������ظ���Value����collection����ŵģ����ظ�
	 * һ��Key-Value�ԣ���һ��Entry�����Ե�Entryʹ��Set��ŵģ������ظ���
	 * 2.��HashMap���Ԫ��ʱ�������Key���ڵ�equals�����������ж�����Key�Ƿ���ͬ�� ����ͬ>>>ֻ����ӽ� ����ӵ��Ǹ�Ԫ��
	 * 
	 */
	@Test
	public void test1() {
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
//		map.put("BB", 456);
		map.put(123, "CC");
		map.put(null, null);
		System.out.println(map.size());// 4
		map.remove("BB");
		System.out.println(map);

		System.out.println(map.get(123));

	}

}
