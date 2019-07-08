package H10;
/*
 * String对象常量池
 * */
/*
 * 静态常量池
 * 动态常量池
 * */
public class list_46_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "www.fstvgo.com";
		String str2 = "www."+"fstvgo"+".com";
		String str3 = "www.fstvgo.";
		String str4 = "com";
		String str5 = str3+str4;
		System.out.println(str1==str2);

	}

}
