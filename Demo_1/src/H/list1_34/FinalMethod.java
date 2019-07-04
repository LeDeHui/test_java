package H.list1_34;

class Parents  {
	// TODO Auto-generated constructor stub
	
	private final void doit() {
		System.out.println("父类doit()");
		
	}
	final void doit2() {
		System.out.println("父类doit2()");
	}
	public void doit3() {
		System.out.println("父类doit3()");
		
	}
}

class Sub extends Parents{
	public final void doit() {
		System.out.print("子类doit()");
	}
//	final void doit2() {
//		System.out.println("子类doit2()");
//	}
	public void doit3() {
		System.out.print("子类doit3()");
		
	}
}



public class FinalMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub sub = new Sub();
		sub.doit(); 
		Parents parents = sub;
		
		parents.doit2();
		parents.doit3();

	}

}
