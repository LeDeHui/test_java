package H_LDH_Test1;
class Person{
	private String nameString;
	private int ageInt;
	public Person (String nameString,int ageInt) {
		nameString = nameString;
		ageInt = ageInt;
	}
	public void show() {
		System.out.println("name : " + nameString + " age : "+ ageInt);
	}
}

public class Demo_01 {
	public static void main(String [] ages) {
		Person person1 = new Person("ÍõÎå", 23) ;
		person1.show();
		
	}

}
