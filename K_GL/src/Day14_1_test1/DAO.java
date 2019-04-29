package Day14_1_test1;
/*定义个泛型DAO<T>，在其中定义一个Map成员变量，Map的键为String类型，值为T类型
 * 
 * 分别创建一下方法：
 * public void save（String id，T entry）：保存T类型对象到Map成员变量中
 * T get（String id）：从map中获取id对应的对象
 * void update（Stringid，Tentry）：替换map中key为id的内容，改为entry对象
 * List<T>list（）：返回map中存放的所有T对象
 * void delete（String id）：删除指定id对象
 * 
 * */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Day09.testCircle;

public class DAO<T> {
	Map<String, T> map ;//= new HashMap<String, T>();

	public void delete(String id) {
		map.remove(id);
	}

	public List<T> list() {
		List<T> list = new ArrayList<T>();
		for (String s : map.keySet()) {
			list.add(map.get(s));
		}
		return list;
	}

	public void update(String id, T entry) {
//		map.remove(id);   //可以省略
		map.put(id, entry);
	}

	public T get(String id) {
		return map.get(id);
	}

	public void save(String id, T entry) {
		map.put(id, entry);
	}

}
