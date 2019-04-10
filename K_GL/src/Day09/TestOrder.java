package Day09;

/***
 * 编写Order类，有int型的orderID，string类的ordername
 * 相应的getter（）settre（）方法，两个参数的构造器，重写父类的方法
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
	//比较两个Order对象的属性是否是完全相同。相同的话，返回True
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
