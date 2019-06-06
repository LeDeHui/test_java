package P11;

final class FinalClass {
	int a = 3;

	void doit() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalClass f = new FinalClass();
		f.a++;
		System.out.println(f.a);
		f.a++;
		System.out.println(f.a);
		abcd aAbcd = new abcd();
		System.out.println(aAbcd.a);
	}
}

class abcd{ 
	int a=3;
	
}