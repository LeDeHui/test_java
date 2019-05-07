package Day19_2_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {

	// ��ȡ����ʱ�������
	@Test
	public void test1() {
		Class class1 = Person.class;
		// getFields():ֻ�ܻ�ȡ������ʱ���м��丸��������Ϊpublic������
		Field[] fields = class1.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		System.out.println();
		// 2.getDeclaredFields():��ȡ����ʱ�౾����������������
		Field[] fields1 = class1.getDeclaredFields();
		for (Field f : fields1) {
			System.out.println(f.getName());
		}
	}

	// Ȩ�����η� �������� ������
	// ��ȡ���Եĸ������ֵ�����
	@Test
	public void test2() {
		Class class1 = Person.class;
		Field[] fields1 = class1.getDeclaredFields();
		for (Field f : fields1) {
			// 1.��ȡÿ�����Ե�Ȩ�����η�
			int i = f.getModifiers();
			String string = Modifier.toString(i);
			System.out.print(string + " ");

			// 2.��ȡÿ�����Եı�������
			Class typeClass = f.getType();
			System.out.print(typeClass + " ");
			// 3.��ȡÿ�����Ե�������
			System.out.print(f.getName());
			System.out.println();
		}
	}
	//��������ʱ����ָ��������
	@Test
	public void test3() throws Exception {
		Class class1 = Person.class;
		//1.��ȡָ��������
		//getField (String fieldName):��ȡ����ʱ������Ϊpublic��ָ��������ΪfisldName ������ 
		//getDeclaredField(String fieldName):��ȡ����ʱ������Ϊָ��������ΪfisldName ������ 
		Field  nameField= class1.getField("name");
		//2.��������ʱ��Ķ���
		Person person = (Person)class1.newInstance();
		System.out.println(person);
		
		//3.������ʱ���ָ�������Ը�ֵ
		nameField.set(person, "Jerry");
		System.out.println( person );
		
		Field  ageField= class1.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(person, 23);
		System.out.println( person );
		//��������Ȩ�����η�������,Ϊ�˱�֤���Ը����Ը�ֵ,��Ҫ�ڲ���ǰʹ�Ĵ����Կɱ�����
		Field  idField= class1.getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(person, 23);
		System.out.println( person );
		
	}
}
