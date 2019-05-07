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
}
