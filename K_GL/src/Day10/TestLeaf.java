package Day10;

class Root{
	static {
		System.out.println("Root�ľ�̬��ʼ��ģ��");//1
	}
	{
		System.out.println("Root����ͨ��ʼ��ģ��");//4
	}
	public Root() {
		System.out.println("Root���޲εĹ�����");//5
	}
}
class Mid extends Root{
	static {
		System.out.println("Mid�ľ�̬��ʼ��ģ��");//2
	}
	{
		System.out.println("Mid����ͨ��ʼ��ģ��");//6
	}
	public Mid() {
		System.out.println("Mid���޲εĹ�����");
	}
	public Mid(String msg) {
		System.out.println("Mid���вεĹ�����,�����ֵΪ:"+msg);//7
	}
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf�ľ�̬��ʼ��ģ��");//3
	}
	{
		System.out.println("Leaf����ͨ��ʼ��ģ��");//8
	}
	public Leaf() {
		super("ASDFG");
		System.out.println("Leaf���޲εĹ�����");//9
	}
	 
}

public class TestLeaf {
	public static void main(String[] args) {
		new Leaf();
	}

}
