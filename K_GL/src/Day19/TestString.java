package Day19;

//�ַ����ķ�ת�ļ��ַ���
//ʱ�临�Ӷ�  �ռ临�Ӷ�  
public class TestString {
	public static void main(String[] args) {
		System.out.println(reverseString1("asdfghjkl"));
		System.out.println(reverseString2("asdfghjkl"));
		System.out.println(reverseString3("asdfghjkl"));
	}

	// ������
	public static String reverseString3(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}

	// ������
	public static String reverseString2(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	// ����һ
	public static String reverseString1(String str) {
		char[] c = str.toCharArray();// �ַ���---->�ַ�����
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
}
