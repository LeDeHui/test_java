package Day11_Test;

import java.util.Scanner;

/* 
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数字存放各类雇员对象的引用
 * 利用循环结构遍历数组元素，输出各个对象的类型，name，number，birthday，以及该对象生日。
 * 当键盘输入本月月份值时，如果本月时某个Employee对象的生日，还要输出增加工资信息。
 * 
 * 
 * */
public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps = new Employee[2];
//		System.out.println(emps[0]);
		emps[0] = new SalariedEmployee("蕾蕾", 1001, new MyDate(2019, 4, 17), 8888);
		emps[1] = new HourlyEmployee("莉莉", 1002, new MyDate(2019, 3, 17), 100, 8);
		Scanner s = new Scanner(System.in);
		System.out.println("请输入本月的月份");
		int month = s.nextInt();
		for (int i = 0; i < emps.length; i++) {
			if (month == emps[i].getBirthday().getMonth()) {
				System.out.println("加100工资");
			}
			System.out.println(emps[i].toString());
		}
	}
}
