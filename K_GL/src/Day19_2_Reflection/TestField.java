package Day19_2_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {

	// 获取运行时类的属性
	@Test
	public void test1() {
		Class class1 = Person.class;
		// getFields():只能获取到运行时类中及其父类中申明为public的属性
		Field[] fields = class1.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		System.out.println();
		// 2.getDeclaredFields():获取运行时类本身申明的所有属性
		Field[] fields1 = class1.getDeclaredFields();
		for (Field f : fields1) {
			System.out.println(f.getName());
		}
	}

	// 权限修饰符 变量类型 变量名
	// 获取属性的各个部分的内容
	@Test
	public void test2() {
		Class class1 = Person.class;
		Field[] fields1 = class1.getDeclaredFields();
		for (Field f : fields1) {
			// 1.获取每个属性的权限修饰符
			int i = f.getModifiers();
			String string = Modifier.toString(i);
			System.out.print(string + " ");

			// 2.获取每个属性的变量类型
			Class typeClass = f.getType();
			System.out.print(typeClass + " ");
			// 3.获取每个属性的属性名
			System.out.print(f.getName());
			System.out.println();
		}
	}
}
