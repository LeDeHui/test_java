package Day19_2_Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runners.model.Annotatable;

public class TestMethod {
	// ע�� Ȩ�����η� ����ֵ���� ������ �β��б� �쳣
	@Test
	public void test2() {
		Class class1 = Person.class;
		Method[] method2 = class1.getDeclaredMethods();
		for (Method m : method2) {
			// 1ע��
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.print(a + " ");
			}

			// 2Ȩ�����η�
			String string = Modifier.toString(m.getModifiers());
			System.out.print(string + " ");
			// 3����ֵ����
			Class returnClass = m.getReturnType();
			System.out.print(returnClass.getName() + " ");
			// 4������
			System.out.print(m.getName() + " ");
			// 5�β��б�
			System.out.print("(");
			Class[] paramsClasses = m.getParameterTypes();
			for (int i = 0; i < paramsClasses.length; i++) {
				System.out.print(paramsClasses[i].getName() + "args-" +i+"  ");
			}
			System.out.print(")");
			// 6�쳣����
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

	// 1.��ȡ����ʱ��ķ���
	@Test
	public void test1() {
		Class class1 = Person.class;
		// getMethods() ��ȡ����ʱ�༰�丸�������е�����Ϊpublic�ķ���
		Method[] method1 = class1.getMethods();
		for (Method m : method1) {
			System.out.println(m);
		}
		System.out.println();
		// 2.getDeclaredMethods():��ȡ����ʱ�౾�����������з���
		Method[] method2 = class1.getDeclaredMethods();
		for (Method m : method2) {
			System.out.println(m);
		}
	}
	
	//��������ʱ����ָ���ķ���
	@Test
	public void test3() throws Exception {
		Class<Person> class1 = Person.class;
		Person person =  (Person)class1.newInstance();
		//getMethod(String methodName,class...params):��ȡ����ʱ��������Ϊpublic�ķ���
		Method m1 = class1.getMethod("show");
		Object returnVal= m1.invoke(person);
		//����ָ���ķ���;invoke(Object odj,Object...obj)
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
		
		Method m5 = class1.getDeclaredMethod("infone" );//(name, parameterTypes) 
 		Object returnVal5 =m5.invoke(person );
  		System.out.println(returnVal5);
		
	}
	
	
	
}
