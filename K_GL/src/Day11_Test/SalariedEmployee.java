package Day11_Test;

/*
 *定义SalariedEmployee类来继承Employee类，实现按月计算工资的员工处理，该类包括：
 *private 成员变量monthlySalary;
 *实现父类的抽象方法earnings（），该方法返回monthlySalary值；
 *toString（）方法输出员工类型信息及name，number和birthday
 *
 * */
public class SalariedEmployee extends Employee {
	private double monthlySalary;

	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(double monthlySalary) {
		super();
		this.monthlySalary = monthlySalary;
	}

	public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return monthlySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [" + super.toString() + "monthlySalary=" + monthlySalary + "]";
	}

}
