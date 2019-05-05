package Day07_Cylinder;

public class Circle {
	private double radius;
	public Circle() {
		radius = 1.0;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public  double findArea() {
		return Math.PI*getRadius()*getRadius();
	}

}
