package H8.list36;
/*
 * 自身关联
 * */
public class list_36_1 {

	public static void main(String[] args) {
		Person per = new Person("张三", 40);
		Person childA = new Person("xiao", 20);
		Person childB = new Person("ming", 18);
		childA.setCar(new Car("BMW",  500000.00));
		childB.setCar(new Car("Benc", 600000.00));
		per.setChildren(new Person[] {childA,childB});
		
		Car car = new Car("吉利", 80000);
		per.setCar(car);
		car.setPerson(per);
		System.out.println(per.getCar().getinfo());
		System.out.println(car.getPerson().getinfo());
		//根据人找到所以的孩子以及孩子对应的车
		for (int i = 0; i < per.getChildren().length; i++) {
			System.out.println("\t|-" + per.getChildren()[i].getinfo());
			System.out.println("\t\t|-" +per.getChildren()[i].getCar().getinfo());
		}
		
	}

}
class  Car{
	private String nameString;
	private double price;
	private Person person;
	public Car(String  nameString,double price) {
		this.nameString = nameString;
		this.price= price;
	}
	public String getinfo() {
		return "Car name : " +this.nameString + " . Car price : " + this.price;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

class Person{
	private String nameString;
	private int age;
	private Car car;
	private Person children []; //一个人可能有多个孩子
	
	public Person[] getChildren() {
		return children;
	}
	public void setChildren(Person[] children) {
		this.children = children;
	}
	public Person(String nameString,int age) {
		this.age= age;
		this.nameString = nameString;
	}
	public String  getinfo() {
		return "Person name : " + this.nameString + " . Person age : " +this.age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}