package Day11_Test;

/*
 * ����SalariedEmployee��������HourlyEmployee�࣬ʵ�ְ�Сʱ���㹤�ʵ�Ա���������������
 *private ��Ա����wage ��hour;
 *ʵ�ָ���ĳ��󷽷�earnings�������÷�������wage * hourֵ��
 *toString�����������Ա��������Ϣ��name��number��birthday
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
