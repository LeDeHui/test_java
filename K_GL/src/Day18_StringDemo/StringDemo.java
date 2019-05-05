package Day18_StringDemo;
/*
 * 1.模拟一个Trim方法,去除字符串两端的空格
 * 2.将一个字符串进行反转.将字符串中指定部分进行反转.比如将 "abcdefg"反转为 "abfedcg"
 * 3.获取一个字符串在另一个字符串中出现的次数.比如 获取 "ab"在  "absdaabdssabkavkkab"中出现的次数
 * 
 * 
 * 
 * */
public class StringDemo {
	public static void main(String[] args) {
		String str = "   nm jkjk op     ";
		// string = " ";
		System.out.println(myTrim(str));

		String str1 = "abcdefghij";
		System.out.println(reverseString(str1, 2, 6));
		System.out.println(reverseString1(str1, 2, 6));
		System.out.println(getCount("absdaabdssabkavkkab", "ab"));
	}
	public static int getCount(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len + str2.length());

		}

		return count;
	}

	// 2.
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start);
		for (int i = end; i >= start; i--) {
			str1 += str.charAt(i);
		}
		str1 += str.substring(end + 1);
		return str1;
	}

	public static String reverseString(String str, int start, int end) {
		char[] c = str.toCharArray();// 字符串---->字符数组
		return reverseArray(c, start, end);
	}
	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);// 字符数组-->字符串
	}
	// 2.
	// 1.
	public static String myTrim(String str) {
		int strat = 0;
		int end = str.length() - 1;
		while (str.charAt(strat) == ' ' & strat < end) {
			strat++;
		}
		while (str.charAt(end) == ' ' & strat < end) {
			end--;
		}
		return str.substring(strat, end + 1);
	}
	// 1.
}
