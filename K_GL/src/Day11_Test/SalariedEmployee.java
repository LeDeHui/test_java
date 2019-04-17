package Day11_Test;

/*
 *����SalariedEmployee�����̳�Employee�࣬ʵ�ְ��¼��㹤�ʵ�Ա���������������
 *private ��Ա����monthlySalary;
 *ʵ�ָ���ĳ��󷽷�earnings�������÷�������monthlySalaryֵ��
 *toString�����������Ա��������Ϣ��name��number��birthday
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
