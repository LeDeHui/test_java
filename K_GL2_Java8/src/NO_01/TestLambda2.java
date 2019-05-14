package NO_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/* 一.Lambda 表达式的基础语法,Java8中引入了一个新的操作符,该操作符简称为箭头操作符或Lambda操作符
 * 			箭头操作符将Lambda表达式拆分为两部分
 * 左侧:Lambda表达式的参数列表
 * 右侧:Lambda表达式中所需要执行的功能,即Lambda体
 * 
 * 语法格式一:无参数无返回值
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * 语法格式二:有一个参数,并且有返回值
 * 		(x) -> System.out.println(x)
 * 
 * 语法格式三:若只有一个参数,小括号可以省略
 * 		x -> System.out.println(x)
 * 
 * 语法格式四:有两个以上的参数,有返回值,并且 Lambda 体中有多条语句 
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("鍑芥暟寮忔帴鍙�");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五::有两个以上的参数,有返回值,并且 Lambda 体中有一条语句,return和大括号都可以省
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * 
 * 语法格式六:Lambda的表达式的参数列表可以省略不写,因为JVM编译器通过上下文推断出数据类型,即"类型推断"
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 左右遇一括号省
 * 左侧类型推断省
 * 
 * 
 * 二 Lambda表达式需要"函数式接口"支持
 * 函数式接口:接口中只有一个抽象方法的接口,称为函数式接口.可以使用注解@FunctionalInterface修饰
 * 			可以坚持时候是函数式接口
 */
public class TestLambda2 {
	
	@Test
	public void test1(){
		int num = 0;//jdk 1.7 以前必须是 final  1.8默认final
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!" + num);
			}
		};
		
		r.run();
		
		System.out.println("-------------------------------");
		
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		r1.run();
	}
	
	@Test
	public void test2(){
		Consumer<String> con = x -> System.out.println(x);
		con.accept("Lambda");
	}
	
	@Test
	public void test3(){
		Comparator<Integer> com = (x, y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		}; 
	}
	
	@Test
	public void test4(){
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
	}
	
	@Test
	public void test5(){
//		String[] strs;
//		strs = {"aaa", "bbb", "ccc"};
		
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());
	}

	public void show(Map<String, Integer> map){
		
	}
	
	//需求:对一个数进行运算
	@Test
	public void test6(){
		Integer num = operation(100, (x) -> x * x);
		System.out.println(num);
		
		System.out.println(operation(200, (y) -> y + 200));
	}
	
	public Integer operation(Integer num, MyFun mf){
		return mf.getValue(num);
	}
}
