package Day11_Test;

import java.util.Scanner;

/* 
 * ����PayrollSystem�࣬����Employee�������鲢��ʼ���������ִ�Ÿ����Ա���������
 * ����ѭ���ṹ��������Ԫ�أ����������������ͣ�name��number��birthday���Լ��ö������ա�
 * ���������뱾���·�ֵʱ���������ʱĳ��Employee��������գ���Ҫ������ӹ�����Ϣ��
 * 
 * 
 * */
public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps = new Employee[2];
//		System.out.println(emps[0]);
		emps[0] = new SalariedEmployee("����", 1001, new MyDate(2019, 4, 17), 8888);
		emps[1] = new HourlyEmployee("����", 1002, new MyDate(2019, 3, 17), 100, 8);
		Scanner s = new Scanner(System.in);
		System.out.println("�����뱾�µ��·�");
		int month = s.nextInt();
		for (int i = 0; i < emps.length; i++) {
			if (month == emps[i].getBirthday().getMonth()) {
				System.out.println("��100����");
			}
			System.out.println(emps[i].toString());
		}
	}
}
