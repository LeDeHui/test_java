package Demo1;

public class Demo_01 {
	public static void main(String [] ages) {
		Person p1 = new Person();
		p1.nameString = "LLLL";
		p1.age = 10;
		Person p2 = p1 ;
		p2.age = 20;
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("p1.age:" + p1.age);
		System.out.println("p2.age:" + p2.age);
	}

}
class Person{
	String nameString;
	int age;
	private void show() {
		System.out.println(" name : " + nameString + " age : "+ age);
	}
}
