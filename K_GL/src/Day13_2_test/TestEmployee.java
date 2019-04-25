package Day13_2_test;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import Day11_Test.MyDate;

/*
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中
 * 分别按一下两张方式对集合中的元素进行排序，并遍历输出
 * 1）使Employee实现Comparable接口，并按name排序
 * 2）创建TreeSet时传入Comparator对象，按生日日期先后排序
 * 
 * 
 * */
public class TestEmployee {

	// 定制排序:创建TreeSet时传入Comparator对象，按生日日期先后排序

	@Test
	public void test2() {
		Comparator com = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee1 && o2 instanceof Employee1) {
					Employee1 e1 = (Employee1) o1;
					Employee1 e2 = (Employee1) o2;
					MyDate birth1 = e1.getBirthday();
					MyDate birth2 = e2.getBirthday();
					if (birth1.getYear() != birth2.getYear()) {
						return birth1.getYear() - birth2.getYear();
					} else {
						if (birth1.getMonth() != birth2.getMonth()) {
							return birth1.getMonth() - birth2.getMonth();
						} else {
							if (birth1.getDay() != birth2.getDay()) {
								return birth1.getDay() - birth2.getDay();
							}
						}
					}
				}

				return 0;

			}

		};
		TreeSet set = new TreeSet(com);
		Employee e1 = new Employee("刘德华", 55, new MyDate(1, 2, 1965));
		Employee e2 = new Employee("郭富城", 43, new MyDate(3, 4, 1964));
		Employee e3 = new Employee("张学友", 33, new MyDate(5, 6, 1961));
		Employee e4 = new Employee("黎明", 54, new MyDate(7, 8, 1955));
		Employee e5 = new Employee("陈奕迅", 65, new MyDate(9, 10, 1959));

		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		for (Object strObject : set) {
			System.out.println(strObject);
		}
	}

	// 自然排序，使用Employee 实现Comparable接口，并 name排序
	@Test
	public void test1() {
		Employee e1 = new Employee("刘德华", 55, new MyDate(1, 2, 1965));
		Employee e2 = new Employee("郭富城", 43, new MyDate(3, 4, 1964));
		Employee e3 = new Employee("张学友", 33, new MyDate(5, 6, 1961));
		Employee e4 = new Employee("黎明", 54, new MyDate(7, 8, 1955));
		Employee e5 = new Employee("陈奕迅", 65, new MyDate(9, 10, 1959));
		TreeSet set = new TreeSet();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);

		for (Object strObject : set) {
			System.out.println(strObject);
		}
	}
}
