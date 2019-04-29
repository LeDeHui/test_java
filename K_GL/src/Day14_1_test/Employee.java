package Day14_1_test;

import java.util.Date;

import Day11_Test.MyDate;
/*
 * 定义一个Employee类
 * 包含private 成员变量 name,age,birthday,其中birthday为MyDate类的对象
 * 为每个属性定义getter  setter方法
 * 重写toString方法
 * */
public class Employee  implements Comparable{

	private String name;
	private Integer age;
	private MyDate birthday;
	 
	public Employee(String name, Integer age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	public Employee() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			return this.name.compareTo(e.name) ;
		}
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result +  age ;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	 
	
	 
	
}
