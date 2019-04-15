package Day10_abstract;
/*
 * ��дһ��Employee�࣬����Ϊ�����࣬���������������ԣ�name,id,salary.
 * �ṩ��Ҫ�Ĺ������ͳ��󷽷���work��������ӦManager����˵��������Ա���������н���bonus�������ԡ�
 * ��ʹ�ü̳е�˼�룬���CommonEmployee���Manager�ࡣ
 * Ҫ�������ṩ��Ҫ�ķ����������Է���
 * */
public class TestEmployee {

}
abstract class Employee{
	String name;
	int id;
	double salary;
	abstract void work();
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
class Manager extends Employee{
	public void work() {
		System.out.println("��д");
	}
}
class CommonEmployee extends Employee{
	public void work() {
		System.out.println("��д");
	}
}
