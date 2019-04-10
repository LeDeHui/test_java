package Day09;

import java.util.Date;

/**
 * 
 * @author ledehui toString()方法
 *
 *         java.lang.object 类的toString（）方法定义如下 public String toString() { return
 *         getClass().getName() + "@" + Integer.toHexString(hashCode()); }
 *         1.当我们打印一个对象的引用时，实际上默认调用的就说这个对象的toString（）方法 2.
 *         当我们打印的对象在类没有重写object中的toSting（）方法是，那么调用的就说object中定义的toString（）方法
 *         返回此对象所在的类及对应的堆空间实体的首地址值
 * 
 *         3.当我们打印的对象在类重写了toString（）方法是，调用的就说我们重写的toString（）方法
 *
 */
public class TestToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("AA",10);
//		Person p2 = new Person();
		System.out.println(p1.toString());
		System.out.println(p1);
		//4.
		String str1 = new String("BB");
		String str2 = "AA";
		System.out.println(str1.toString());
		System.out.println(str2.toString());
		
		Date d  = new Date();
		System.out.println(d);

	}

}
class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

