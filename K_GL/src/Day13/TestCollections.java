package Day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * ����Collection�Լ�Map�Ĺ����� Collections:
 * 
 * 
 * 
 * 
 * 
 * */
public class TestCollections {
	/*
	 * Object max(Collection):����Ԫ�ص���Ȼ����˳��,���ظ��������е����Ԫ��
	 * Object max(Collection.Comparator):����Comparatorָ����˳��,���ظ��������е�
	 * Object min(Collection)
	 * Object min(Collection.Comparator)
	 * int frequency(Collection  ,object):����ָ��������ָ��Ԫ�س��ֵĴ���
	 * void copy(List dest,List src):��src�е����ݸ��Ƶ�dest��
	 * boolean replaceAll(List list,Object lodVal,Object newVal):ʹ����ֵ�滻List�еľ�ֵ
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
//		List list1 = new ArrayList();������ʵ�ַ�ʽ
		List list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		//�̰߳�ȫ��:ͨ�����·�����֤list���̰߳�ȫ  list2Ϊ�̰߳�ȫ��
		List list2 = Collections.synchronizedList(list);
		System.out.println(list2);
	}
	/*
	 * reverse(List):��תList��Ԫ�ص�˳��
	 * shuffle(List):��List����Ԫ�ؽ����������
	 * sort(List):����Ԫ�ص���Ȼ˳���ָ����List����Ԫ�ذ���������
	 * sort(List.Comparator):����ָ����Comparator������˳���List����Ԫ�ؽ�������
	 * swap(List,int,int):��ָ��List�����е�I��Ԫ�غ�J��Ԫ�ؽ��н���
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
