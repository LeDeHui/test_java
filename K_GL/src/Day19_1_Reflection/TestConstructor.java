package Day19_1_Reflection;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws Exception {
		String className = "Day19_1_Reflection.Person";
		Class class1 = Class.forName(className);
		// 创建对应的运行时对象..使用newInstance(),实际上就说调用了运行时类的空参构造器

		// 要想能够创建成功①要求对应的运行时类要有空参的构造器②构造器的权限修饰符的权限要足够
		Object obj = class1.newInstance();
		Person p = (Person) obj;
		System.out.println(p);
	}
}
