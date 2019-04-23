package Day12_4_List;
 
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import Day12_3_Collection.Person;

public class TestLinkedList {
	@Test
	public void testCollection3() {
		LinkedList   coll = new LinkedList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		System.out.println(coll);
		LinkedList coll1 = new LinkedList();
		coll1.add(123);
		coll1.add("AA");
		System.out.println(coll1);
		// 10removeALL（Collection coll）：从当前集合中删除包含在coll1中的元素。差集
		coll.removeAll(coll1);
		System.out.println(coll);
		//11.equals（Object obj）：判断集合中的所有元素是否完全相同
		LinkedList coll2 = new LinkedList();
		coll2.add(123);
		coll2.add("AA");
		System.out.println(coll1.equals(coll2));
		//12.hascode():
		System.out.println(coll1.hashCode());
		//13.toArray():将集合转换为数组
		Object[]  obj  = coll.toArray();
		for(int i = 0;i<obj.length;i++) {
			System.out.println(obj[i]);
		}
		System.out.println();
		//14.iterator():返回一个iterator接口类实现的对象,进而实现集合的遍历
		Iterator intrator = coll.iterator();
//		for (int i = 0 ;i< coll.size();i++) {
//		System.out.println(intrator.next());}
		
		//
		while(intrator.hasNext()) {
			System.out.println(intrator.next().hashCode());
		}
}
}
