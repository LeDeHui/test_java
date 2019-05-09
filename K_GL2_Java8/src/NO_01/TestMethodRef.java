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
 * 涓�銆佹柟娉曞紩鐢細鑻� Lambda 浣撲腑鐨勫姛鑳斤紝宸茬粡鏈夋柟娉曟彁渚涗簡瀹炵幇锛屽彲浠ヤ娇鐢ㄦ柟娉曞紩鐢�
 * 			  锛堝彲浠ュ皢鏂规硶寮曠敤鐞嗚В涓� Lambda 琛ㄨ揪寮忕殑鍙﹀涓�绉嶈〃鐜板舰寮忥級
 * 
 * 1. 瀵硅薄鐨勫紩鐢� :: 瀹炰緥鏂规硶鍚�
 * 
 * 2. 绫诲悕 :: 闈欐�佹柟娉曞悕
 * 
 * 3. 绫诲悕 :: 瀹炰緥鏂规硶鍚�
 * 
 * 娉ㄦ剰锛�
 * 	 鈶犳柟娉曞紩鐢ㄦ墍寮曠敤鐨勬柟娉曠殑鍙傛暟鍒楄〃涓庤繑鍥炲�肩被鍨嬶紝闇�瑕佷笌鍑芥暟寮忔帴鍙ｄ腑鎶借薄鏂规硶鐨勫弬鏁板垪琛ㄥ拰杩斿洖鍊肩被鍨嬩繚鎸佷竴鑷达紒
 * 	 鈶¤嫢Lambda 鐨勫弬鏁板垪琛ㄧ殑绗竴涓弬鏁帮紝鏄疄渚嬫柟娉曠殑璋冪敤鑰咃紝绗簩涓弬鏁�(鎴栨棤鍙�)鏄疄渚嬫柟娉曠殑鍙傛暟鏃讹紝鏍煎紡锛� ClassName::MethodName
 * 
 * 浜屻�佹瀯閫犲櫒寮曠敤 :鏋勯�犲櫒鐨勫弬鏁板垪琛紝闇�瑕佷笌鍑芥暟寮忔帴鍙ｄ腑鍙傛暟鍒楄〃淇濇寔涓�鑷达紒
 * 
 * 1. 绫诲悕 :: new
 * 
 * 涓夈�佹暟缁勫紩鐢�
 * 
 * 	绫诲瀷[] :: new;
 * 
 * 
 */
public class TestMethodRef {
	//鏁扮粍寮曠敤
	@Test
	public void test8(){
		Function<Integer, String[]> fun = (args) -> new String[args];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);
		
		System.out.println("--------------------------");
		
		Function<Integer, Employee[]> fun2 = Employee[] :: new;
		Employee[] emps = fun2.apply(20);
		System.out.println(emps.length);
	}
	
	//鏋勯�犲櫒寮曠敤
	@Test
	public void test7(){
		Function<String, Employee> fun = Employee::new;
		
		BiFunction<String, Integer, Employee> fun2 = Employee::new;
	}
	
	@Test
	public void test6(){
		Supplier<Employee> sup = () -> new Employee();
		System.out.println(sup.get());
		
		System.out.println("------------------------------------");
		
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
	}
	
	//绫诲悕 :: 瀹炰緥鏂规硶鍚�
	@Test
	public void test5(){
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
	
	//绫诲悕 :: 闈欐�佹柟娉曞悕
	@Test
	public void test4(){
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		
		System.out.println("-------------------------------------");
		
		Comparator<Integer> com2 = Integer::compare;
	}
	
	@Test
	public void test3(){
		BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
		System.out.println(fun.apply(1.5, 22.2));
		
		System.out.println("--------------------------------------------------");
		
		BiFunction<Double, Double, Double> fun2 = Math::max;
		System.out.println(fun2.apply(1.2, 1.5));
	}

	//瀵硅薄鐨勫紩鐢� :: 瀹炰緥鏂规硶鍚�
	@Test
	public void test2(){
		Employee emp = new Employee(101, "寮犱笁", 18, 9999.99);
		
		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());
		
		System.out.println("----------------------------------");
		
		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());
	}
	
	@Test
	public void test1(){
		PrintStream ps = System.out;
		Consumer<String> con = (str) -> ps.println(str);
		con.accept("Hello World锛�");
		
		System.out.println("--------------------------------");
		
		Consumer<String> con2 = ps::println;
		con2.accept("Hello Java8锛�");
		
		Consumer<String> con3 = System.out::println;
	}
	
}
