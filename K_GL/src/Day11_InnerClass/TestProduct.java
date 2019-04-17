package Day11_InnerClass;

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		// ��ʽһ������һ��ʵ��Product�ӿڵ���Ķ��󣬲����˶����뷽����
		NoteBook n = new NoteBook();
		t.show(n);
		// ��ʽ����������һ��ʵ��Product�ӿڵ�������Ķ���
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
		// ��ʽ����������һ��ʵ��Product�ӿڵ����������������
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

//�ֲ��ڲ����ʹ��
	public Product getProduct() {
		// ��ʽһ��ʵ��Product��ڵľֲ��ڲ���
//	 class Camera implements Product {
//
//			@Override
//			public void getName() {
//				System.out.println("���");
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

		// ��ʽ����ʵ��Product��ڵ������ľֲ��ڲ���
		return new Product() {

			@Override
			public void getPrict() {
				System.out.println("9000");

			}

			@Override
			public void getName() {
				System.out.println("�������");

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
		System.out.println("HP�ʼǱ�");

	}

	@Override
	public void getPrict() {
		System.out.println("5000");

	}

}