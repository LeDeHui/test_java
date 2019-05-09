package NO_01;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

public class TestLambda1111 {
	@Test
	public void test1() {
		
		Comparator<Integer> comparator  = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
			
		};
		TreeSet<Integer> ts = new TreeSet<Integer>(comparator);
		
		
		
		
	}
	//Lambda
	@Test
	public void test2() {
		Comparator<Integer>  com = (x,y)->Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<Integer>(com);
	}
	

}
