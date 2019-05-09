package NO_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 涓�銆丼tream API 鐨勬搷浣滄楠わ細
 * 
 * 1. 鍒涘缓 Stream
 * 
 * 2. 涓棿鎿嶄綔
 * 
 * 3. 缁堟鎿嶄綔(缁堢鎿嶄綔)
 */
public class TestStreamaAPI {
	
	//1. 鍒涘缓 Stream
	@Test
	public void test1(){
		//1. Collection 鎻愪緵浜嗕袱涓柟娉�  stream() 涓� parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream(); //鑾峰彇涓�涓『搴忔祦
		Stream<String> parallelStream = list.parallelStream(); //鑾峰彇涓�涓苟琛屾祦
		
		//2. 閫氳繃 Arrays 涓殑 stream() 鑾峰彇涓�涓暟缁勬祦
		Integer[] nums = new Integer[10];
		Stream<Integer> stream1 = Arrays.stream(nums);
		
		//3. 閫氳繃 Stream 绫讳腑闈欐�佹柟娉� of()
		Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
		
		//4. 鍒涘缓鏃犻檺娴�
		//杩唬
		Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
		stream3.forEach(System.out::println);
		
		//鐢熸垚
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);
		
	}
	
	//2. 涓棿鎿嶄綔
	List<Employee> emps = Arrays.asList(
			new Employee(102, "鏉庡洓", 59, 6666.66),
			new Employee(101, "寮犱笁", 18, 9999.99),
			new Employee(103, "鐜嬩簲", 28, 3333.33),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(104, "璧靛叚", 8, 7777.77),
			new Employee(105, "鐢颁竷", 38, 5555.55)
	);
	
	/*
	  绛涢�変笌鍒囩墖
		filter鈥斺�旀帴鏀� Lambda 锛� 浠庢祦涓帓闄ゆ煇浜涘厓绱犮��
		limit鈥斺�旀埅鏂祦锛屼娇鍏跺厓绱犱笉瓒呰繃缁欏畾鏁伴噺銆�
		skip(n) 鈥斺�� 璺宠繃鍏冪礌锛岃繑鍥炰竴涓墧鎺変簡鍓� n 涓厓绱犵殑娴併�傝嫢娴佷腑鍏冪礌涓嶈冻 n 涓紝鍒欒繑鍥炰竴涓┖娴併�備笌 limit(n) 浜掕ˉ
		distinct鈥斺�旂瓫閫夛紝閫氳繃娴佹墍鐢熸垚鍏冪礌鐨� hashCode() 鍜� equals() 鍘婚櫎閲嶅鍏冪礌
	 */
	
	//鍐呴儴杩唬锛氳凯浠ｆ搷浣� Stream API 鍐呴儴瀹屾垚
	@Test
	public void test2(){
		//鎵�鏈夌殑涓棿鎿嶄綔涓嶄細鍋氫换浣曠殑澶勭悊
		Stream<Employee> stream = emps.stream()
			.filter((e) -> {
				System.out.println("娴嬭瘯涓棿鎿嶄綔");
				return e.getAge() <= 35;
			});
		
		//鍙湁褰撳仛缁堟鎿嶄綔鏃讹紝鎵�鏈夌殑涓棿鎿嶄綔浼氫竴娆℃�х殑鍏ㄩ儴鎵ц锛岀О涓衡�滄儼鎬ф眰鍊尖��
		stream.forEach(System.out::println);
	}
	
	//澶栭儴杩唬
	@Test
	public void test3(){
		Iterator<Employee> it = emps.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void test4(){
		emps.stream()
			.filter((e) -> {
				System.out.println("鐭矾锛�"); // &&  ||
				return e.getSalary() >= 5000;
			}).limit(3)
			.forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		emps.parallelStream()
			.filter((e) -> e.getSalary() >= 5000)
			.skip(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test6(){
		emps.stream()
			.distinct()
			.forEach(System.out::println);
	}
}
