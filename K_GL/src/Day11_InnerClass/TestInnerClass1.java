package Day11_InnerClass;

/*
 * 关于局部内部类的使用
 * */
public class TestInnerClass1 {

}

class OuterClass {
	// 局部内部类
	// 如下的使用方法较少
	public void method1() {
		class InnerClass {

		}
	}

	// 常常使用一个方法使其返回值为某个类或借口的对象，而这个类或借口在方法内部创建
	//使用方式一
	public Comparable getComparable() {
		//1.创建一个实现getComparable借口的类:局部内部类
		class myComparable  implements Comparable{

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		//2.返回一个实现类的对象
		return new myComparable();
	}
	
	//使用方式二
	public Comparable getComparable1() {		 	
		//返回一个实现Comparable接口的匿名内部类的对象
		return  new Comparable () {

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		 
	}
}