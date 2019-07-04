package H.list1_34;

public class OuterClass {
	innerClass in = new innerClass(); 
	public void ouf() {
		in.inf();
	}
	class innerClass{
		public innerClass() {
			// TODO Auto-generated constructor stub
		}
		public void inf() {
			
		}
		int y = 0;
	}
	public innerClass  doit() {
		in.y=4;
		return new innerClass();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass out = new  OuterClass();
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
	}

}
