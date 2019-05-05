package Day18;

import org.junit.Test; 

public class TestString {
	/**/
	@Test
	public void test4() {
			
	}
	/*
	 *  public int length()
	 *  public char charAt(int index):返回在指定index位置的字符。index从0开始
	 *  public boolean equals(object object):比较两个字符串是否相等。相等true，否是false
	 *  public int compareTo(String anotherString):
	 *  public indexOf(String s):返回s字符串在当前字符串首次出现的位置，若无，返回-1
	 *  public indexOf(String s，int startpoint)：返回s字符串从当前字符串startpoint位置开始的首次出现的位置
	 *  public lastIndexof(String s):返回s字符串在当前字符串最后一次出现的位置，若无，返回-1
	 *  public lastindexOf(String s，int startpoint)：返回s字符串从当前字符串startpoint位置开始的最后一次出现的位置
	 *  public boolean startWith(String prsfix):判断当前字符串是否以prsfix开始的
	 *  public boolean endswith(String suffix)：判断当前字符串是否以suffix结束的
	 *  public boolean regionMatches(int firstStart,String other,String otherStart,int length):
	 *  	判断当前字符串firstStart开始的子串与另一个字符串other从otherStart开始，length长度的字符串是否equals
	 *  
	 * */
	@Test
	public void test3() {
		String str1 = "abccdefgbcc";
		String str2 = "abcc";
		String str3 = "efgbcc";
		System.out.println(str1.length());
		System.out.println(str1.charAt(0));
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals("abcc"));
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.indexOf("bcc"));
		System.out.println(str1.lastIndexOf("bcc"));
		System.out.println(str1.startsWith("abc"));
		System.out.println(str1.endsWith("bcc"));
		System.out.println(str1.regionMatches(5, str3, 0, str3.length()));
	}
	/*
	 * String:代表不可变的字符序列。底层使用char[]存放
	 * String 是final的
	 * */
	@Test
	public void test1() {
		String str1 = "JavaEE";
		String str2 = "JavaEE";
		String str3 = new String("JavaEE");
		String str4 = "JavaEE" + "Android";
		String str5 = "Android";
		String str6 = str1 + str5;
		str5 = str5 + "Doop";		
		String str7 = str6.intern();
		String str8 = "JavaEEAndroid";
		
		System.out.println(str1 == str2);//T
		System.out.println(str1 ==str3);//F
		System.out.println(str1.equals(str3));//T
		
		System.out.println(str4 ==str6);//F
		System.out.println(str4.equals(str6));//T
		System.out.println(str7 == str4);//T
		System.out.println(str4 ==str8);//T
	}
}
