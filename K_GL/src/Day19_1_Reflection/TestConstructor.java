package Day19_1_Reflection;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws Exception {
		String className = "Day19_1_Reflection.Person";
		Class class1 = Class.forName(className);
		// ������Ӧ������ʱ����..ʹ��newInstance(),ʵ���Ͼ�˵����������ʱ��Ŀղι�����

		// Ҫ���ܹ������ɹ���Ҫ���Ӧ������ʱ��Ҫ�пղεĹ������ڹ�������Ȩ�����η���Ȩ��Ҫ�㹻
		Object obj = class1.newInstance();
		Person p = (Person) obj;
		System.out.println(p);
	}
}
