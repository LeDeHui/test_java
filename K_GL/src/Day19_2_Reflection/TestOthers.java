package Day19_2_Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOthers {
	// 6.获取注解
	public void test6() {
		Class class1 = Person.class;
		Annotation[] annsAnnotations = class1.getAnnotations();
		for (Annotation a : annsAnnotations) {
			System.out.println(a);
		}

	}

	// 5获取所在的包
	public void test5() {
		Class class1 = Person.class;
		Package package1 = class1.getPackage();
		System.out.println(package1);

	}

	// 4.获取实现的接口
	@Test
	public void test4() {
		Class class1 = Person.class;
		Class[] interfaceClasses = class1.getInterfaces();
		for (Class i : interfaceClasses) {
			System.out.println(i);
		}
	}

	// 3 获取父类的泛型
	@Test
	public void test3() {
		Class class1 = Person.class;
		Type type1 = class1.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type1;
		Type[] arsTypes = parameterizedType.getActualTypeArguments();
		System.out.println(((Class) arsTypes[0]).getName());
	}

	// 2 获取带泛型的父类
	@Test
	public void test2() {
		Class class1 = Person.class;
		Type type1 = class1.getGenericSuperclass();
		System.out.println(type1);
	}

	// 1 获取运行时类的父类
	@Test
	public void test1() {
		Class class1 = Person.class;
		Class superClass = class1.getSuperclass();
		System.out.println(superClass);
	}

}
