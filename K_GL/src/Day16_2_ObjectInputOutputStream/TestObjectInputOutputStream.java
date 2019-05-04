package Day16_2_ObjectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	// 对象的反序列化过程:将硬盘中的文件通过ObjectInputStream转换为相应的对象
	@Test
	public void TestObjectIntputStream() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("ObjectPerson.txt"));
			Person p1 = (Person) ois.readObject();
			System.out.println(p1);
			Person p2 = (Person) ois.readObject();
			System.out.println(p2);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 对象的的序列化过程,将内存中的对象用过ObjectInputStream转换为二进制流,存储在硬盘中
	@Test
	public void TestObjectOutputStream() {
		Person p1 = new Person("小米", 23);
		Person p2 = new Person("红米", 21);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("ObjectPerson.txt"));
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

//要实现序列化的类
/*
 * 1.要求此类是可序列化的:实现Serializable接口
 * 2.要求类的属性同样实现Serializable接口
 * 3.提供一个版本号private static final long serialVersionUid 
 * 4.使用static或transient修饰的属性,不可实例化
 */
class Person implements Serializable {
	private static final long serialVersionUid = 123L;
	String name;
	Integer age;

	public Person(String name, Integer age) {
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