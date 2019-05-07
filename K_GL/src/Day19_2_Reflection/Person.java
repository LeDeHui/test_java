package Day19_2_Reflection;

@MyAnnotion(value = "atLe")
public class Person extends Creature<String> implements Comparable, MyInterface {
	public String name;
	private int age;
	int id;

	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
		System.out.println("ok");
	}

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

	@MyAnnotion(value = "atDeHui")
	public void show() {
		System.out.println("����һ����");
	}

	private void display(String nation) throws Exception {
		System.out.println("�ҵĹ����ǣ�" + nation);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	class Bird {

	}
}
