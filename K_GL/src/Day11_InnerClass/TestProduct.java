package Day11_InnerClass;

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		// 方式一：创建一个实现Product接口的类的对象，并将此对象传入方法中
		NoteBook n = new NoteBook();
		t.show(n);
		// 方式二：创建了一个实现Product接口的匿名类的对象
		Product p = new Product() {

			@Override
			public void getPrict() {
				System.out.println("3200");

			}

			@Override
			public void getName() {
				System.out.println("MI");

			}
		};
		// t.show(p);
		// 方式三：创建了一个实现Product接口的匿名类的匿名对象
		t.show(new Product() {

			@Override
			public void getName() {
				System.out.println("5288");

			}

			@Override
			public void getPrict() {
				System.out.println("iphone");

			}
		});
		System.out.println();
		Product p1 = t.getProduct();
		p1.getName();
		p1.getPrict();
	}

//局部内部类的使用
	public Product getProduct() {
		// 方式一：实现Product借口的局部内部类
//	 class Camera implements Product {
//
//			@Override
//			public void getName() {
//				System.out.println("相机");
//
//			}
//
//			@Override
//			public void getPrict() {
//				System.out.println("8000");
//
//			}
//
//		}
//		return new Camera();
//
//	}

		// 方式二：实现Product借口的匿名的局部内部类
		return new Product() {

			@Override
			public void getPrict() {
				System.out.println("9000");

			}

			@Override
			public void getName() {
				System.out.println("数码相机");

			}
		};
	}

	public void show(Product p) {
		p.getName();
		p.getPrict();

	}
}

interface Product {
	void getName();

	void getPrict();
}

class NoteBook implements Product {

	@Override
	public void getName() {
		System.out.println("HP笔记本");

	}

	@Override
	public void getPrict() {
		System.out.println("5000");

	}

}