package Day19_1_Reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {
	// ������ļ����� ClassLoader
	@Test
	public void test5() throws Exception {
		ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader1);

		ClassLoader classLoader2 = classLoader1.getParent();
		System.out.println(classLoader2);

		ClassLoader classLoader3 = classLoader2.getParent();
		System.out.println(classLoader3);// null

		Class class1 = Person.class;
		ClassLoader classLoader4 = class1.getClassLoader();
		System.out.println(classLoader4);

		String className = "java.lang.Object";
		Class class2 = class1.forName(className);
		ClassLoader classLoader5 = class2.getClassLoader();
		System.out.println(classLoader5);

		// ��������
//		ClassLoader classLoader = this.getClass().getClassLoader();
//		InputStream is = classLoader.getResourceAsStream("Day19_1_Reflection\\jdbc.properties");
		
		FileInputStream is = new FileInputStream("jdbc.properties");
		
		
		
		Properties pros = new Properties();
		pros.load(is);
		String name = pros.getProperty("user");
		System.out.println(name);
		
		String password = pros.getProperty("password");
		System.out.println(password);
	}

	// ��λ�ȡClass��ʵ��
	@Test
	public void test4() throws ClassNotFoundException {
		// 1.��������ʱ�౾���.class����
		Class<Person> class1 = Person.class;
		System.out.println(class1.getName());
		Class<String> class2 = String.class;
		System.out.println(class2.getName());

		// 2.ͨ������ʱ��Ķ����ȡ
		Person p = new Person();
		Class<? extends Person> class3 = p.getClass();
		System.out.println(class3.getName());

		// 3.ͨ��Class�ľ�̬������ȡ
		String className = "Day19_1_Reflection.Person";
		Class class4 = Class.forName(className);
		System.out.println(class4.getName());

		// 4.ͨ����ļ�����
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class class5 = classLoader.loadClass(className);
		System.out.println(class5.getName());
	}

	// java.lang.Class:�Ƿ����Դͷ
	/*
	 * ���Ǵ�����ͬһ����,ͨ������(javac.exe)���ɶ�Ӧ��.class�ļ� ֮������ʹ��java.exe���� (JVM�����������)��.class�ļ�
	 * ��.class�ļ����ص��ڴ��Ժ�,��˵һ����������. ��ŵĻ�����,��ô�������ʱ�౾�����һ��Class��ʵ�� 1.ÿһ������ʱ��ֻ������һ��
	 * 2.����Class��ʵ���Ժ�,���ǻ����Խ������µĲ��� 1)������Ӧ������ʱ��Ķ��� 2)���Ի�ȡ����ʱ��������ṹ(���� ���� ������ �ڲ��� ����
	 * ���ڵİ� �쳣 ע��.....) 3)���ö�Ӧ������ʱ��ָ���Ľṹ(���� ���� ������...) 4)�����Ӧ��:��̬����
	 * 
	 * 
	 */
	@Test
	public void test3() {
		Person p = new Person();
		Class class1 = p.getClass();
		// ͨ������ʱ��Ķ���,����getclass(),����������ʱ��
		System.out.println(class1);

	}

	// ���˷���,ͨ������һ����Ķ���,���������еĽṹ
	@Test
	public void test2() throws Exception {
		Class<Person> clazz = Person.class;
		// 1.����clazz��Ӧ������ʱ��Person��Ķ���
		Person p = clazz.newInstance();
		System.out.println(p);
		// 2.ͨ�������������ʱ���ָ������
		// 2.1
		Field f1 = clazz.getField("name");
		f1.set(p, "ledehui");
		System.out.println(p);
		// 2.2
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		// 3.ͨ�������������ʱ���ָ������
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "CHN");
	}

	// ���з�����ǰ����δ���һ����Ķ��󣬲����������Է���
	@Test
	public void test1() {
		Person p = new Person();
		p.setAge(20);
		p.setName("Le");
		System.out.println(p.toString());
		p.show();
		p.display("HK");
	}
}
