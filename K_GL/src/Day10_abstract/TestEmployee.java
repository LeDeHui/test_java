package Day10_abstract;

/*
 * 编写一个Employee类，声明为抽象类，包含如下三个属性：name,id,salary.
 * 提供必要的构造器和抽象方法：work（）。对应Manager类来说，他既是员工，还具有奖金（bonus）的属性。
 * 请使用继承的思想，设计CommonEmployee类和Manager类。
 * 要求类中提供必要的方法进行属性访问
 * */
public class TestEmployee {
	public static void main(String[] args) {
//		Manager m1 = new Manager();
		Employee e1 = new Manager();
		e1.work();
		Employee e2 = new CommonEmployee();
		e2.work();
		e2.setId(8);
		System.out.println(e2.getId());
		System.out.println(e1.getId());
	}

}
//管理者类
class Manager extends Employee {
	private double bonus;
	
	public void work() {
		System.out.println("Manager重写");
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
//一般员工
class CommonEmployee extends Employee {
	public void work() {
		System.out.println("CommonEmployee重写");
	}
}

abstract class Employee {
	private String name;
	private int id;
	private double salary;

	abstract public void work();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

}
