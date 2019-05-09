package NO_01_exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import NO_01.Employee;


public class TestLambda {
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "寮犱笁", 18, 9999.99),
			new Employee(102, "鏉庡洓", 59, 6666.66),
			new Employee(103, "鐜嬩簲", 28, 3333.33),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(105, "鐢颁竷", 38, 5555.55)
	);
	
	@Test
	public void test1(){
		Collections.sort(emps, (e1, e2) -> {
			if(e1.getAge() == e2.getAge()){
					return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test2(){
		String trimStr = strHandler("\t\t\t 鎴戝ぇ灏氱璋峰▉姝�   ", (str) -> str.trim());
		System.out.println(trimStr);
		
		String upper = strHandler("abcdef", (str) -> str.toUpperCase());
		System.out.println(upper);
		
		String newStr = strHandler("鎴戝ぇ灏氱璋峰▉姝�", (str) -> str.substring(2, 5));
		System.out.println(newStr);
	}
	
	//闇�姹傦細鐢ㄤ簬澶勭悊瀛楃涓�
	public String strHandler(String str, MyFunction mf){
		return mf.getValue(str);
	}
	
	@Test
	public void test3(){
		op(100L, 200L, (x, y) -> x + y);
		
		op(100L, 200L, (x, y) -> x * y);
	}
	
	//闇�姹傦細瀵逛簬涓や釜 Long 鍨嬫暟鎹繘琛屽鐞�
	public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
		System.out.println(mf.getValue(l1, l2));
	}

}
