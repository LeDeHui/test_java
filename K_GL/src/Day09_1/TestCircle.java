package Day09_1;
//static ��һ��Ӧ��;ʹ�þ�̬�ı�������ʵ���ۼӵ�Ч��
public class TestCircle {
	public static void main(String[] args) {
		Cricle c1 = new Cricle(2.0);
		Cricle c2 = new Cricle(2.1);
		System.out.println(Cricle.getTotal());

	}

}

class Cricle {
	private double radius;// �뾶
	private static String info = "����һ��԰";
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
