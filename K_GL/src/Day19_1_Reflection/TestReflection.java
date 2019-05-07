package Day19_1_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	// 关于类的加载器 ClassLoader
	@Test
	public void test5() {
		
		
	}

	// 如何获取Class的实例
	@Test
	public void test4() throws ClassNotFoundException {
		// 1.调用运行时类本身的.class属性
		Class<Person> class1 = Person.class;
		System.out.println(class1.getName());
		Class<String> class2 = String.class;
		System.out.println(class2.getName());

		// 2.通过运行时类的对象获取
		Person p = new Person();
		Class<? extends Person> class3 = p.getClass();
		System.out.println(class3.getName());

		// 3.通过Class的静态方法获取
		String className = "Day19_1_Reflection.Person";
		Class class4 = Class.forName(className);
		System.out.println(class4.getName());

		// 4.通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class class5 = classLoader.loadClass(className);
		System.out.println(class5.getName());
	}

	// java.lang.Class:是反射的源头
	/*
	 * 我们创建了同一个类,通过编译(javac.exe)生成对应的.class文件 之后我们使用java.exe加载 (JVM的类加载器完)此.class文件
	 * 此.class文件加载到内存以后,就说一个运行是类. 存放的缓存区,那么这个运行时类本身就是一个Class的实例 1.每一个运行时类只被加载一次
	 * 2.有了Class的实例以后,我们还可以进行如下的操作 1)创建对应的运行时类的对象 2)可以获取运行时类的完整结构(属性 方法 构造器 内部类 父类
	 * 所在的包 异常 注解.....) 3)调用对应的运行时类指定的结构(属性 方法 构造器...) 4)反射的应用:动态代理
	 * 
	 * 
	 */
	@Test
	public void test3() {
		Person p = new Person();
		Class class1 = p.getClass();
		// 通过运行时类的对象,调用getclass(),返回其运行时类
		System.out.println(class1);

	}

	// 有了反射,通过创建一个类的对象,并调用其中的结构
	@Test
	public void test2() throws Exception {
		Class<Person> clazz = Person.class;
		// 1.创建clazz对应的运行时类Person类的对象
		Person p = clazz.newInstance();
		System.out.println(p);
		// 2.通过反射调用运行时类的指定属性
		// 2.1
		Field f1 = clazz.getField("name");
		f1.set(p, "ledehui");
		System.out.println(p);
		// 2.2
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		// 3.通过反射调用运行时类的指定方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "CHN");
	}

	// 在有反射以前。如何创建一个类的对象，并调用其属性方法
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
