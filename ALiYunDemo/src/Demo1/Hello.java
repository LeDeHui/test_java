package Demo1;

public class Hello {

	public static void main(String[] args) {
		String str = "hello" ;
		switch (str) {
			case "Hello":{
				System.out.println("Hello") ;
				break ;
			}
			case "hello": {
				System.out.println("hello") ;
				break ;
			}
			default: {
				System.out.println("NoMatch") ;
			}
		}
		// TODO Auto-generated method stub
		//System.out.println("10");
		/*int a = 12;
		int b = 15;
		a= a^b;
		b= a^b;
		a= a^b;
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		Hello1 hello1 = new Hello1();
		hello1.name();*/
		/*
		int ch = 2 ;
		switch (ch) {
			case 2 :
				System.out.println("设置的内容是2。") ;
				break ;
			case 1 : {
				System.out.println("设置的内容是1。") ;
				break ;
			}
			default : {
				System.out.println("没有内容满足。") ;
				break ;
			}
		}*/
	}

}
