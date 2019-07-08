package H10;
/*
 * String类对象两种实例化方式比较
 * */
public class list45_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2 );
		String str3 =  new String("abc");
		String str4 = new String("abc");
		System.out.println(str3 == str4 );
	}

}
