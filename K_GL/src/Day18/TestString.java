package Day18;

import org.junit.Test; 

public class TestString {
	/*
	 *  public int length()
	 *  public char charAt(int index):������ָ��indexλ�õ��ַ���index��0��ʼ
	 *  public boolean equals(object object):�Ƚ������ַ����Ƿ���ȡ����true������false
	 *  public int compareTo(String anotherString):
	 *  public indexOf(String s):����s�ַ����ڵ�ǰ�ַ����״γ��ֵ�λ�ã����ޣ�����-1
	 *  public indexOf(String s��int startpoint)������s�ַ����ӵ�ǰ�ַ���startpointλ�ÿ�ʼ���״γ��ֵ�λ��
	 *  public lastIndexof(String s):����s�ַ����ڵ�ǰ�ַ������һ�γ��ֵ�λ�ã����ޣ�����-1
	 *  public lastindexOf(String s��int startpoint)������s�ַ����ӵ�ǰ�ַ���startpointλ�ÿ�ʼ�����һ�γ��ֵ�λ��
	 *  public boolean startWith(String prsfix):�жϵ�ǰ�ַ����Ƿ���prsfix��ʼ��
	 *  public boolean endswith(String suffix)���жϵ�ǰ�ַ����Ƿ���suffix������
	 *  public boolean regionMatches(int firstStart,String other,String otherStart,int length):
	 *  	�жϵ�ǰ�ַ���firstStart��ʼ���Ӵ�����һ���ַ���other��otherStart��ʼ��length���ȵ��ַ����Ƿ�equals
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
	 * String:�������ɱ���ַ����С��ײ�ʹ��char[]���
	 * String ��final��
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