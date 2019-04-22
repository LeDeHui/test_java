package Day11;

/*
 * ����һ���ӿ���ʵ����������ıȽ�
 * interface CompareOjbect{
 * public int compareTo(Object obj);
 *������ֵ��0 ��������ȡ���Ϊ����������ǰ���
 * }
 * ����һ��Circle��
 * ����һ��ComparableCircle�࣬�̳�Circle�ಢʵ��CompareOjbect��ڣ�
 * 	��ComparableCircle���и�������з���compareTo��ʵ�廯��
 * 	�����Ƚ�����԰�İ뾶��С
 * ����һ��������TestCircle����������ComparableCircle���󣬵���compareTo�����Ƚ�������İ뾶��С
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
			 throw new RuntimeException("����ķ�ComparableCircle���ͣ����ɱȽ�");
		}

	}

}
