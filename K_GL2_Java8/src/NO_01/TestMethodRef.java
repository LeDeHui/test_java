package NO_01;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * 	一.方法引用:若Lambda 体中的内容有方法已经实现了,我们可以使用"方法引用"
 * 		(可以理解为方法引用是Lambda 表达式的另一种表形式)
 * 	只要有三种语法格式:
 * 
 * 	对象 :: 实例名
 * 
 * 	类 :: 静态方法名
 * 
 * 	类 :: 实例方法名
 * 
 * 注意:
 * 	1.Lambda 体中调用方法的参数列表与返回值类型,要以函数式接口中抽象方法的函数列表和返回值保存一致
 * 	2.若Lambda 参数列表中的第一个参数是  实例方法调用者,而第二个参数的实例方法的参数时,可以使用ClassName::method
 * 	二.构造器引用	
 * 	格式:
 * 	ClassName::new
 * 
 */
public class TestMethodRef {
	// 鏁扮粍寮曠敤
	@Test
	public void test8() {
		Function<Integer, String[]> fun = (args) -> new String[args];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);

		System.out.println("--------------------------");

		Function<Integer, Employee[]> fun2 = Employee[]::new;
		Employee[] emps = fun2.apply(20);
		System.out.println(emps.length);
	}

	//构造器引用
	@Test
	public void test7() {
		Function<String, Employee> fun = Employee::new;

		BiFunction<String, Integer, Employee> fun2 = Employee::new;
	}

	//构造器引用
	@Test
	public void test6() {
		Supplier<Employee> sup = () -> new Employee();
		System.out.println(sup.get());

		System.out.println("------------------------------------");

		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
	}

	// 类::实例方法名
	@Test
	public void test5() {
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		System.out.println(bp.test("abcde", "abcde"));

		System.out.println("-----------------------------------------");

		BiPredicate<String, String> bp2 = String::equals;
		System.out.println(bp2.test("abc", "abc"));

		System.out.println("-----------------------------------------");

		Function<Employee, String> fun = (e) -> e.show();
		System.out.println(fun.apply(new Employee()));

		System.out.println("-----------------------------------------");

		Function<Employee, String> fun2 = Employee::show;
		System.out.println(fun2.apply(new Employee()));

	}

	// 类 ::静态方法名
	@Test
	public void test4() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

		System.out.println("-------------------------------------");

		Comparator<Integer> com2 = Integer::compare;
	}

	@Test
	public void test3() {
		BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
		System.out.println(fun.apply(1.5, 22.2));

		System.out.println("--------------------------------------------------");

		BiFunction<Double, Double, Double> fun2 = Math::max;
		System.out.println(fun2.apply(1.2, 1.5));
	}

	// 对象 :: 实例方法名
	@Test
	public void test2() {
		Employee emp = new Employee(101, "寮犱笁", 18, 9999.99);

		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());

		System.out.println("----------------------------------");

		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());
	}

	@Test
	public void test1() {
		PrintStream ps = System.out;
		Consumer<String> con = (str) -> ps.println(str);
		con.accept("Hello World!!");

		System.out.println("--------------------------------");

		Consumer<String> con2 = ps::println;
		con2.accept("Hello Java8!!");

		Consumer<String> con3 = System.out::println;
	}

}
