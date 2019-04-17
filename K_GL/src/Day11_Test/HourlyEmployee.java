package Day11_Test;

/*
 * 参照SalariedEmployee类来定义HourlyEmployee类，实现按小时计算工资的员工处理，该类包括：
 *private 成员变量wage 和hour;
 *实现父类的抽象方法earnings（），该方法返回wage * hour值；
 *toString（）方法输出员工类型信息及name，number和birthday
 *
 * 
 * */

public class HourlyEmployee extends Employee {
	private double wage;
	private double hour;

	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "HourlyEmployee ["+super.toString()+"wage=" + wage + ", hour=" + hour + "]";
	}

	public double getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return getHour() * getWage();
	}

}
