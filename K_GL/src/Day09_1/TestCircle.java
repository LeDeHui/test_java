package Day09_1;
//static 的一个应用;使用静态的变量可以实现累加的效果
public class TestCircle {
	public static void main(String[] args) {
		Cricle c1 = new Cricle(2.0);
		Cricle c2 = new Cricle(2.1);
		System.out.println(Cricle.getTotal());

	}

}

class Cricle {
	private double radius;// 半径
	private static String info = "我是一个园";
	private static int total = 0;

	public Cricle(double radius) {
		super();
		this.radius = radius;
		total++;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static String getInfo() {
		return info;
	}

	public static void setInfo (String info) {
		Cricle.info = info;
	}

	public static void setTotal(int total) {
		Cricle.total = total;
	}

	public static void show() {
		System.out.println(info);
	}

	@Override
	public String toString() {
		return "Cricle [radius=" + radius + "]";
	}

	public static int getTotal() {
		return total;
	}

}
