package H.list35;
 

/*
 * 类关联结构
 * 
 * */
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


public class list_35_1 {

	public static void main(String[] args) {
		Person per = new Person("张三", 20);
		Car car = new Car("吉利", 80000);
		per.setCar(car);
		car.setPerson(per);
		System.out.println(per.getCar().getinfo());
		System.out.println(car.getPerson().getinfo());

	}

}
