package Day09;

public class testCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testCircle t1 = new testCircle();
//		GeometricObject g1 = new GeometricObject("as",23);
//		System.out.println(g1.getColor() + g1.getWeight());
		Circle c1 = new Circle(2.3);
		Circle c2 = new Circle(2.3);
		System.out.println(c1.getColor() + c1.getRadius() + c1.getWeight());
		System.out.println(c1.findArea());
		System.out.println(c1.equals(c2));
		System.out.println(c1.toString());

	}

}
