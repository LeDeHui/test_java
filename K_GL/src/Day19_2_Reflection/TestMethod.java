package Day19_2_Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runners.model.Annotatable;

public class TestMethod {
	// 注解 权限修饰符 返回值类型 方法名 形参列表 异常
	@Test
	public void test2() {
		Class class1 = Person.class;
		Method[] method2 = class1.getDeclaredMethods();
		for (Method m : method2) {
			// 1注解
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.print(a + " ");
			}

			// 2权限修饰符
			String string = Modifier.toString(m.getModifiers());
			System.out.print(string + " ");
			// 3返回值类型
			Class returnClass = m.getReturnType();
			System.out.print(returnClass.getName() + " ");
			// 4方法名
			System.out.print(m.getName() + " ");
			// 5形参列表
			System.out.print("(");
			Class[] paramsClasses = m.getParameterTypes();
			for (int i = 0; i < paramsClasses.length; i++) {
				System.out.print(paramsClasses[i].getName() + "args-" +i+"  ");
			}
			System.out.print(")");
			// 6异常类型
			Class[] expClass = m.getExceptionTypes();
			if(expClass.length != 0 ) {
				System.out.print("throws ");
			}
			for (int i = 0; i < expClass.length; i++) {
				System.out.print (expClass[i]+ " " );
			}
			System.out.println();
		}

	}

	// 1.获取运行时类的方法
	@Test
	public void test1() {
		Class class1 = Person.class;
		// getMethods() 获取运行时类及其父类中所有的声明为public的方法
		Method[] method1 = class1.getMethods();
		for (Method m : method1) {
			System.out.println(m);
		}
		System.out.println();
		// 2.getDeclaredMethods():获取运行时类本身申明的所有方法
		Method[] method2 = class1.getDeclaredMethods();
		for (Method m : method2) {
			System.out.println(m);
		}
	}
}
