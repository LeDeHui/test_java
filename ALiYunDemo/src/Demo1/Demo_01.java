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
		p1.setid("I  Love You");
		System.out.println(p1.getid( ));
	}

}
class Person{
	String nameString;
	int age;
	private String id;
	//构造方法
	public Person(String nameString, int age, String id) {
		super();
		this.nameString = nameString;
		this.age = age;
		this.id = id; 
	}
	public Person( ) {
		super();		 
	}
	public void setid(String iString){
		this.id = iString;
	}
	public String getid(){
		return id;
	}
	
	private void show() {
		System.out.println(" name : " + nameString + " age : "+ age);
	}
}
