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
}
