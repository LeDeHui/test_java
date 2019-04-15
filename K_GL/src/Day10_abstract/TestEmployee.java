package Day10_abstract;

/*
 * ��дһ��Employee�࣬����Ϊ�����࣬���������������ԣ�name,id,salary.
 * �ṩ��Ҫ�Ĺ������ͳ��󷽷���work��������ӦManager����˵��������Ա���������н���bonus�������ԡ�
 * ��ʹ�ü̳е�˼�룬���CommonEmployee���Manager�ࡣ
 * Ҫ�������ṩ��Ҫ�ķ����������Է���
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
//��������
class Manager extends Employee {
	private double bonus;
	
	public void work() {
		System.out.println("Manager��д");
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
//һ��Ա��
class CommonEmployee extends Employee {
	public void work() {
		System.out.println("CommonEmployee��д");
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
