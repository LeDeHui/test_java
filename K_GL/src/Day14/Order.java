package Day14;

import java.util.List;
import java.util.ArrayList;

/*
 *�Զ��巺����
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

	
	//�������ͷ���
	public <E> E getE(E e) {
		return e;
	}
	//ʵ�����鵽���ϵĸ���
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

//�̳з�������ͽӿ�ʱ������ָ�����͵�����
class SubOrder extends Order<Integer>{
	
}
