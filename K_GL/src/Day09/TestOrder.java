package Day09;

/***
 * ��дOrder�࣬��int�͵�orderID��string���ordername
 * ��Ӧ��getter����settre�������������������Ĺ���������д����ķ���
 * 
 * @author ledehui
 *
 */
public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order(1001, "AA");
		Order o2 = new Order(1001, "AA");
		System.out.println(o1 == o2);
		System.out.println(o1.equals(o2));
		System.out.println(o1.getOrderName() == o2.getOrderName());
	}

}

class Order {
	private int OrderId;
	private String OrderName;

	public Order() {
		super();
	}

	public Order(int orderId, String orderName) {
		super();
		OrderId = orderId;
		OrderName = orderName;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}
	//�Ƚ�����Order����������Ƿ�����ȫ��ͬ����ͬ�Ļ�������True
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Order) {
			Order o1 = (Order) obj;
			return this.OrderId == o1.OrderId && this.OrderName.equals(o1.OrderName);
		} else {
			return false;
		}

	}
}
