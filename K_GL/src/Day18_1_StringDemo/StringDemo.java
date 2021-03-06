package Day18_1_StringDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*	算法构造
 * 1.模拟一个Trim方法,去除字符串两端的空格
 * 2.将一个字符串进行反转.将字符串中指定部分进行反转.比如将 "abcdefg"反转为 "abfedcg"
 * 3.获取一个字符串在另一个字符串中出现的次数.比如 获取 "ab"在  "absdaabdssabkavkkab"中出现的次数
 * 4.获取两个字符串中最大的子串 比如 "asdfghjklhelloqwertyuiop" , "axfhelloq"
 * 5.对字符串中的字符进行自热顺序排序
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
		List<String> strs = getMaxSubString("asdfghjklhelloqwertyuiop", "yuiopasdfgwhello");
		System.out.println(strs);
		System.out.println(sort("asdfghjkl"));
	}
	//5.
	public static String sort(String str) {
		char[] c = str.toCharArray();
		 Arrays.sort(c);
		return new String(c);
	}
	
	
	//5.

	// 4.
	public static List<String> getMaxSubString(String str1, String str2) {
		String maxStr = (str1.length() > str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len = minStr.length();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= i; j++) {
				if (maxStr.indexOf(minStr.substring(i - j, len - j)) != -1) {
					String str = minStr.substring(i - j, len - j);
					list.add(str);
				}				
			}
//			for (int x = 0, y = len - i; y <= len; x++, y++) {
//				String str = minStr.substring(x, y);
//				if (maxStr.contains(str)) {
//					list.add(str);
//				}
//			}

			if (list.size() != 0) {
				return list;
			}
		}
		return null;
	}

	// 4.
	// 3.
	public static int getCount(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len + str2.length());

		}

		return count;
	}
	// 3.

	// 2.
	// 方法一
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start);
		for (int i = end; i >= start; i--) {
			str1 += str.charAt(i);
		}
		str1 += str.substring(end + 1);
		return str1;
	}

	// 方法二
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
