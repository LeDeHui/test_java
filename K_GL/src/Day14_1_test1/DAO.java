package Day14_1_test1;
/*���������DAO<T>�������ж���һ��Map��Ա������Map�ļ�ΪString���ͣ�ֵΪT����
 * 
 * �ֱ𴴽�һ�·�����
 * public void save��String id��T entry��������T���Ͷ���Map��Ա������
 * T get��String id������map�л�ȡid��Ӧ�Ķ���
 * void update��Stringid��Tentry�����滻map��keyΪid�����ݣ���Ϊentry����
 * List<T>list����������map�д�ŵ�����T����
 * void delete��String id����ɾ��ָ��id����
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
//		map.remove(id);   //����ʡ��
		map.put(id, entry);
	}

	public T get(String id) {
		return map.get(id);
	}

	public void save(String id, T entry) {
		map.put(id, entry);
	}

}
