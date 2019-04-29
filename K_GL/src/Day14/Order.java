package Day14;

import java.util.List;
import java.util.ArrayList;

/*
 *自定义泛型类
 * 
 * */
public class Order<T> {
	private String Ordername;
	private int ordId;
	private T t;
	List<T> list = new ArrayList<>();

	public void add() {
		list.add(t);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
//不可以在static的方法中使用泛型的声明
//	public static void show() {
//		System.out.println(t);
//	}
//	
	//不能再try  catch中使用泛型的声明
//	public   void info() {
//	try {
//		
//	} catch (t e) {
//		// TODO: handle exception
//	}
//	}
	//声明泛型方法
	public <E> E getE(E e) {
		return e;
	}
	//实现数组到集合的复制
	public <E>  List<E>   fromArrayToCollection(E[] e,List<E>  list) {
		for(E e1:e) {
			list.add(e1);
		}
		return list;
	}
	
	
	public String getOrdername() {
		return Ordername;
	}

	public void setOrdername(String ordername) {
		Ordername = ordername;
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	@Override
	public String toString() {
		return "Order [Ordername=" + Ordername + ", ordId=" + ordId + ", t=" + t + "]";
	}

}

//继承泛型类或泛型接口时，可以指明泛型的类型
class SubOrder extends Order<Integer>{
	
}
