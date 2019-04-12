package Day10;

/*
 * �������Ը�ֵ�Ĳ���  1Ĭ�ϳ�ʼ��   2��ʾ�ĳ�ʼ���������ʼ��(˳��ִ��)  3������   4ͨ���������Ӧ���Խ����޸�
 * ��ĵ��ĸ���Ա;��ʼ����(�����)
 *	1�������������εĻ�,ֻ��ʹ��static.
 * 	2���� 
 * 	��̬�����:
 * 		1���������������
 * 		2������ļ��ض�����,����ֻ������һ��
 * 		3�����̬�����֮�䰴��˳��ṹִ��.
 * 		4��̬�����ִ��Ҫ���ڷǾ�̬�����ִ��
 * 		5�ھ�̬�Ĵ������,ֻ��ִ�о�̬�Ľṹ(������.�෽��)
 *	�Ǿ�̬����� 
 *		1���Զ��������(��̬&�Ǿ�̬)���г�ʼ������
 *		2���������������
 *		3һ�����п��� �ж���Ǿ�̬�����.��������֮�䰴��˳��ṹִ��
 *		4ÿ����һ����Ķ���,�Ǿ�̬�����ִ��һ��
 *		5�Ǿ�̬������ִ��Ҫ���ڹ�����
 * 
 * 
 * */
public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order();
		System.out.println(o1);
		Order o2 = new Order();
		System.out.println(o2);
	}
}

class Order {
	private int orderId = 1001;
	private String orderName;
	//��̬�����
	static{
		System.out.println("��̬�����1");
	}
	// ��ʼ���� �Ǿ�̬�����
	 {
		 orderId = 1003;
		 orderName = "b";
		System.out.println("�Ǿ�̬�����2");
	}
	 {
		 orderId = 1002;
		 orderName = "a";
		 System.out.println("�Ǿ�̬�����1");
	 }

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public Order() {
		super();
		System.out.println("Order�ղεĹ�����");
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}

}