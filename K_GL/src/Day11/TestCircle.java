package Day11;

/*
 * 定义一个接口来实现两个对象的比较
 * interface CompareOjbect{
 * public int compareTo(Object obj);
 *若返回值是0 ，代表相等。若为正数，代表前面的
 * }
 * 定义一个Circle类
 * 定义一个ComparableCircle类，继承Circle类并实现CompareOjbect借口，
 * 	在ComparableCircle类中给出借口中方法compareTo的实体化，
 * 	用来比较两个园的半径大小
 * 定义一个测试类TestCircle，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小
 * 
 * */
public class TestCircle {
	public static void main(String[] args) {

		ComparableCircle c1 = new ComparableCircle(2.3);
		ComparableCircle c2 = new ComparableCircle(2.1);
		ComparableCircle c3 = new ComparableCircle(2.3);
//		int i1 = c1.compareTo(  c2);
//		int i2 = c1.compareTo( ( c3);
//		System.out.println(i1);
//		System.out.println(i2);
	}
}

interface CompareOjbect {
	int compareTo(Object obj);
}

class Circle {
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}

class ComparableCircle extends Circle implements CompareOjbect {
	public ComparableCircle() {

	}

	public ComparableCircle(double raduis) {
		super(raduis);
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj) {
			return 0;
		} else if (obj instanceof ComparableCircle) {
			ComparableCircle circle = (ComparableCircle) obj;
			if (this.getRadius() > circle.getRadius())
				return 1;
			else if (this.getRadius() < circle.getRadius()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			throw new RuntimeException("传入的非ComparableCircle类型，不可比较");
		}

	}

}
