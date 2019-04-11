package Day09;

public class Circle extends GeometricObject {
	private double radius;

	public Circle() {
		super();
		this.radius = 1.0;

	}

	public Circle(double radius) {
		super();
		this.radius = radius;

	}

	public Circle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}

	public Circle(String color, double weight) {
		super(color, weight);
	}

	public Circle(String color) {
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//Ô²µÄÃæ»ý
	public double findArea() {
		return Math.PI * this.getRadius()* this.getRadius()  ;

	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

}