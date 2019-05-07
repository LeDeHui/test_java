package Day19;

//字符串的反转的几种方法
//时间复杂度  空间复杂度  
public class TestString {
	public static void main(String[] args) {
		System.out.println(reverseString1("asdfghjkl"));
		System.out.println(reverseString2("asdfghjkl"));
		System.out.println(reverseString3("asdfghjkl"));
	}

	// 方法三
	public static String reverseString3(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}

	// 方法二
	public static String reverseString2(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	// 方法一
	public static String reverseString1(String str) {
		char[] c = str.toCharArray();// 字符串---->字符数组
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
}
