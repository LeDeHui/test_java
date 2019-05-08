package Day19_3_Proxy;
//��̬����ģʽ

//�ӿ�
interface ClothFactory {
	void productCloth();
}

//��������
class NikeClothFactory implements ClothFactory {

	@Override
	public void productCloth() {
		System.out.println("Nike��������һ���·�");

	}

}

//������
class ProxyFactory implements ClothFactory {
	ClothFactory cf;

//����������Ķ���ʱ,ʵ�ʴ���һ����������Ķ���
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("�����࿪ʼִ��");
		cf.productCloth();
		System.out.println("���������");
	}

}

public class TestClothProduct {
	public static void main(String[] args) {
		NikeClothFactory nike = new NikeClothFactory();
		//������������Ķ���
		ProxyFactory proxyFactory = new ProxyFactory(nike);
		//����������Ķ���
		proxyFactory.productCloth();
	}
}
