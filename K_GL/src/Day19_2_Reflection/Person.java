package Day19_2_Reflection;

@MyAnnotion(value = "atLe")
public class Person extends Creature<String> implements Comparable, MyInterface {
	public String name;
	private int age;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		System.out.println("我是一个人");
	}

	public String show1() {
		System.out.println("我是一个中国人");
		return "AA";
	}

	private void display(String nation) throws Exception {
		System.out.println("我的国籍是：" + nation);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ",Id = " + id + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void info() {
		System.out.println("Static_method");

	}
	public  int  infone(  ) {
		System.out.println("Static_method" + "str1");
		return 123;

	}

	class Bird {

	}
}
