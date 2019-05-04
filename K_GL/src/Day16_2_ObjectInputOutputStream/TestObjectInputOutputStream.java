package Day16_2_ObjectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	// ����ķ����л�����:��Ӳ���е��ļ�ͨ��ObjectInputStreamת��Ϊ��Ӧ�Ķ���
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

	// ����ĵ����л�����,���ڴ��еĶ����ù�ObjectInputStreamת��Ϊ��������,�洢��Ӳ����
	@Test
	public void TestObjectOutputStream() {
		Person p1 = new Person("С��", 23);
		Person p2 = new Person("����", 21);
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

//Ҫʵ�����л�����
/*
 * 1.Ҫ������ǿ����л���:ʵ��Serializable�ӿ�
 * 2.Ҫ���������ͬ��ʵ��Serializable�ӿ�
 * 3.�ṩһ���汾��private static final long serialVersionUid 
 * 4.ʹ��static��transient���ε�����,�������л�
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