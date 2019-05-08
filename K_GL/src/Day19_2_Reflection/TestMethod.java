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
	
	//调用运行时类中指定的方法
	@Test
	public void test3() throws Exception {
		Class<Person> class1 = Person.class;
		Person person =  (Person)class1.newInstance();
		//getMethod(String methodName,class...params):获取运行时类中声明为public的方法
		
		Method m1 = class1.getMethod("show");
		Object returnVal= m1.invoke(person);
		//调用指定的方法;invoke(Object odj,Object...obj)
		System.out.println(returnVal);
		
		Method m2 = class1.getMethod("toString");
		Object returnVal1 = m2.invoke(person);
		System.out.println(returnVal1);
		
		Method m3 = class1.getDeclaredMethod("show1");
		Object returnVal2 = m3.invoke(person);
		System.out.println(returnVal2);
		
		Method m4 = class1.getDeclaredMethod("info");
		Object returnVal4 = m4.invoke(person);
		System.out.println(returnVal4);
		
		/*有返回值  带参数的*/
		Method m5 = class1.getDeclaredMethod("infone" ,String.class); 
		m5.setAccessible(true);
		Object returnVal5 =m5.invoke(person,"ww" );
  		System.out.println(returnVal5);
  		
  		Method m6 = class1.getDeclaredMethod("display", String.class);
  		m6.setAccessible(true);
  		Object returnVal6 =m6.invoke(person,"ww" );
  		System.out.println(returnVal6);
	}
	
	
	
}
