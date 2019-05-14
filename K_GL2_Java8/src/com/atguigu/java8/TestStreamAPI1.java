package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 	一. Stream 的三个操作步骤
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI1 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "鏉庡洓", 59, 6666.66),
			new Employee(101, "寮犱笁", 18, 9999.99),
			new Employee(103, "鐜嬩簲", 28, 3333.33),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(105, "鐢颁竷", 38, 5555.55)
	);
	
	//2. 涓棿鎿嶄綔
	/*
		鏄犲皠
		map鈥斺�旀帴鏀� Lambda 锛� 灏嗗厓绱犺浆鎹㈡垚鍏朵粬褰㈠紡鎴栨彁鍙栦俊鎭�傛帴鏀朵竴涓嚱鏁颁綔涓哄弬鏁帮紝璇ュ嚱鏁颁細琚簲鐢ㄥ埌姣忎釜鍏冪礌涓婏紝骞跺皢鍏舵槧灏勬垚涓�涓柊鐨勫厓绱犮��
		flatMap鈥斺�旀帴鏀朵竴涓嚱鏁颁綔涓哄弬鏁帮紝灏嗘祦涓殑姣忎釜鍊奸兘鎹㈡垚鍙︿竴涓祦锛岀劧鍚庢妸鎵�鏈夋祦杩炴帴鎴愪竴涓祦
	 */
	@Test
	public void test1(){
		Stream<String> str = emps.stream()
			.map((e) -> e.getName());
		
		System.out.println("-------------------------------------------");
		
		List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		
		Stream<String> stream = strList.stream()
			   .map(String::toUpperCase);
		
		stream.forEach(System.out::println);
		
		Stream<Stream<Character>> stream2 = strList.stream()
			   .map(TestStreamAPI1::filterCharacter);
		
		stream2.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		
		System.out.println("---------------------------------------------");
		
		Stream<Character> stream3 = strList.stream()
			   .flatMap(TestStreamAPI1::filterCharacter);
		
		stream3.forEach(System.out::println);
	}

	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
	
	/*
		sorted()鈥斺�旇嚜鐒舵帓搴�
		sorted(Comparator com)鈥斺�斿畾鍒舵帓搴�
	 */
	@Test
	public void test2(){
		emps.stream()
			.map(Employee::getName)
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		emps.stream()
			.sorted((x, y) -> {
				if(x.getAge() == y.getAge()){
					return x.getName().compareTo(y.getName());
				}else{
					return Integer.compare(x.getAge(), y.getAge());
				}
			}).forEach(System.out::println);
	}
}
