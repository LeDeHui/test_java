package Day12_2_Exception;
 
//1.手动的抛出一个异常的例子
//2.抛出的异常类型，若是RuntimrException。可以不显式的处理
//若是一个Exception，必须要显式的处理。
public class TestCircle {
	 
	 public static void main(String[] args) {
		
	
		Circle c1 = new Circle(3.2);
		Circle c2 = new Circle(3.2);
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.compareTo(new String("AA")));
	 }
}

class Circle { 
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	public int compareTo(Object obj) {
		if (this == obj) {
			return 0;
		} else if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.radius > c.radius) {
				return 1;
			} else if (this.radius == c.radius) {
				return 0;
			} else {
				return -1;
			}
		}else {
			//手动的抛出一个异常
			//throw new RuntimeException("1错误");
			throw new  MyException("传入的类型有误");
			
			
		}
		
	}
}