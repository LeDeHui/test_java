package Day10;

/*
 * 关于属性赋值的操作  1默认初始化   2显示的初始化或代码块初始化(顺序执行)  3构造器   4通过对象的相应属性进行修改
 * 类的第四个成员;初始化快(代码块)
 *	1代码块如果有修饰的话,只能使用static.
 * 	2分类 
 * 	静态代码块:
 * 		1里面可以有输出语句
 * 		2随着类的加载而加载,而且只被加载一次
 * 		3多个静态代码块之间按照顺序结构执行.
 * 		4静态代码块执行要早于非静态代码块执行
 * 		5在静态的代码块中,只能执行静态的结构(类属性.类方法)
 *	非静态代码块 
 *		1可以对类的属性(静态&非静态)进行初始化操作
 *		2里面可以有输出语句
 *		3一个类中可以 有多个非静态代码块.多个代码块之间按照顺序结构执行
 *		4每创建一个类的对象,非静态代码块执行一次
 *		5非静态代码块的执行要早于构造器
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
	//静态代码块
	static{
		System.out.println("静态代码块1");
	}
	// 初始化块 非静态代码块
	 {
		 orderId = 1003;
		 orderName = "b";
		System.out.println("非静态代码块2");
	}
	 {
		 orderId = 1002;
		 orderName = "a";
		 System.out.println("非静态代码块1");
	 }

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public Order() {
		super();
		System.out.println("Order空参的构造器");
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