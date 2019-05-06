package Day18_StringDemo;
/*
 * 1.ģ��һ��Trim����,ȥ���ַ������˵Ŀո�
 * 2.��һ���ַ������з�ת.���ַ�����ָ�����ֽ��з�ת.���罫 "abcdefg"��תΪ "abfedcg"
 * 3.��ȡһ���ַ�������һ���ַ����г��ֵĴ���.���� ��ȡ "ab"��  "absdaabdssabkavkkab"�г��ֵĴ���
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
	//3.
	public static int getCount(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len + str2.length());

		}

		return count;
	}
	//3.

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
		char[] c = str.toCharArray();// �ַ���---->�ַ�����
		return reverseArray(c, start, end);
	}
	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);// �ַ�����-->�ַ���
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
