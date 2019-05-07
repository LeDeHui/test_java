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
	//调用运行时类中指定的属性
	@Test
	public void test3() throws Exception {
		Class class1 = Person.class;
		//1.获取指定的属性
		//getField (String fieldName):获取运行时类声明为public的指定属性名为fisldName 的属性 
		//getDeclaredField(String fieldName):获取运行时类声明为指定属性名为fisldName 的属性 
		Field  nameField= class1.getField("name");
		//2.创建运行时类的对象
		Person person = (Person)class1.newInstance();
		System.out.println(person);
		
		//3.将运行时类的指定的属性赋值
		nameField.set(person, "Jerry");
		System.out.println( person );
		
		Field  ageField= class1.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(person, 23);
		System.out.println( person );
		//由于属性权限修饰符的限制,为了保证可以给属性赋值,需要在操作前使的此属性可被操作
		Field  idField= class1.getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(person, 23);
		System.out.println( person );
		
	}
}
