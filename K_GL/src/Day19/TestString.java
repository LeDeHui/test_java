package Day19;
//�ַ����ķ�ת
public class TestString {
	public static void main(String[] args) {
		System.out.println(reverseString("asdfghjkl"));
 		System.out.println(reverseString1("asdfghjkl"));		
		System.out.println(reverseString2("asdfghjkl"));
	}

	// ������
	public static String reverseString2(String str ) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		return sb.toString();
	}
	// ������
	public static String reverseString1(String str ) {
		String str1= ""  ;
		for (int i = str.length()-1; i >= 0; i--) {
			str1 += str.charAt(i);
		} 
		return str1;
	}

	// ����һ
	public static String reverseString(String str ) {
		char[] c = str.toCharArray();// �ַ���---->�ַ�����
		for (int i = 0, j = str.length()-1; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}

	 
}
