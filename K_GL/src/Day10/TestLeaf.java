package Day10;

class Root{
	static {
		System.out.println("Root的静态初始化模块");//1
	}
	{
		System.out.println("Root的普通初始化模块");//4
	}
	public Root() {
		System.out.println("Root的无参的构造器");//5
	}
}
class Mid extends Root{
	static {
		System.out.println("Mid的静态初始化模块");//2
	}
	{
		System.out.println("Mid的普通初始化模块");//6
	}
	public Mid() {
		System.out.println("Mid的无参的构造器");
	}
	public Mid(String msg) {
		System.out.println("Mid的有参的构造器,其参数值为:"+msg);//7
	}
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf的静态初始化模块");//3
	}
	{
		System.out.println("Leaf的普通初始化模块");//8
	}
	public Leaf() {
		super("ASDFG");
		System.out.println("Leaf的无参的构造器");//9
	}
	 
}

public class TestLeaf {
	public static void main(String[] args) {
		new Leaf();
	}

}
