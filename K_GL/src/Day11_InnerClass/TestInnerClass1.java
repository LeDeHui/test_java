package Day11_InnerClass;

/*
 * ���ھֲ��ڲ����ʹ��
 * */
public class TestInnerClass1 {

}

class OuterClass {
	// �ֲ��ڲ���
	// ���µ�ʹ�÷�������
	public void method1() {
		class InnerClass {

		}
	}

	// ����ʹ��һ������ʹ�䷵��ֵΪĳ������ڵĶ��󣬶����������ڷ����ڲ�����
	//ʹ�÷�ʽһ
	public Comparable getComparable() {
		//1.����һ��ʵ��getComparable��ڵ���:�ֲ��ڲ���
		class myComparable  implements Comparable{

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		//2.����һ��ʵ����Ķ���
		return new myComparable();
	}
	
	//ʹ�÷�ʽ��
	public Comparable getComparable1() {		 	
		//����һ��ʵ��Comparable�ӿڵ������ڲ���Ķ���
		return  new Comparable () {

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		 
	}
}