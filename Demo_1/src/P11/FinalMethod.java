package P11;

class Parents  {
	// TODO Auto-generated constructor stub
	
	private final void doit() {
		System.out.println("����doit()");
		
	}
	final void doit2() {
		System.out.println("����doit2()");
	}
	public void doit3() {
		System.out.println("����doit3()");
		
	}
}

class Sub extends Parents{
	public final void doit() {
		System.out.print("����doit()");
	}
//	final void doit2() {
//		System.out.println("����doit2()");
//	}
	public void doit3() {
		System.out.print("����doit3()");
		
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
