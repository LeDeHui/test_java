package NO_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * Java8 鍐呯疆鐨勫洓澶ф牳蹇冨嚱鏁板紡鎺ュ彛
 * 
 * Consumer<T> : 娑堣垂鍨嬫帴鍙�
 * 		void accept(T t);
 * 
 * Supplier<T> : 渚涚粰鍨嬫帴鍙�
 * 		T get(); 
 * 
 * Function<T, R> : 鍑芥暟鍨嬫帴鍙�
 * 		R apply(T t);
 * 
 * Predicate<T> : 鏂█鍨嬫帴鍙�
 * 		boolean test(T t);
 * 
 */
public class TestLambda3 {
	
	//Predicate<T> 鏂█鍨嬫帴鍙ｏ細
	@Test
	public void test4(){
		List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	//闇�姹傦細灏嗘弧瓒虫潯浠剁殑瀛楃涓诧紝鏀惧叆闆嗗悎涓�
	public List<String> filterStr(List<String> list, Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		
		for (String str : list) {
			if(pre.test(str)){
				strList.add(str);
			}
		}
		
		return strList;
	}
	
	//Function<T, R> 鍑芥暟鍨嬫帴鍙ｏ細
	@Test
	public void test3(){
		String newStr = strHandler("\t\t\t 鎴戝ぇ灏氱璋峰▉姝�   ", (str) -> str.trim());
		System.out.println(newStr);
		
		String subStr = strHandler("鎴戝ぇ灏氱璋峰▉姝�", (str) -> str.substring(2, 5));
		System.out.println(subStr);
	}
	
	//闇�姹傦細鐢ㄤ簬澶勭悊瀛楃涓�
	public String strHandler(String str, Function<String, String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> 渚涚粰鍨嬫帴鍙� :
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		
		for (Integer num : numList) {
			System.out.println(num);
		}
	}
	
	//闇�姹傦細浜х敓鎸囧畾涓暟鐨勬暣鏁帮紝骞舵斁鍏ラ泦鍚堜腑
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}
	
	//Consumer<T> 娑堣垂鍨嬫帴鍙� :
	@Test
	public void test1(){
		happy(10000, (m) -> System.out.println("浣犱滑鍒氬摜鍠滄澶у疂鍓戯紝姣忔娑堣垂锛�" + m + "鍏�"));
	} 
	
	public void happy(double money, Consumer<Double> con){
		con.accept(money);
	}
}
