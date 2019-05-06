package Day18;

import org.junit.Test; 

public class TestString {
	/* 1.�ַ���������������ͣ���װ��֮���ת��
	 * 		��  �ַ���-->�����������ͣ���װ�ࣺ������Ӧ�İ�װ���ParseXXX����
	 *  	��  �����������ͣ���װ��-->�ַ����������ַ��������ص�valueOf()
	 * 2.�ַ������ֽ�����֮���ת��
	 * 		�� �ַ���-->�ֽ����飺�����ַ�����getBates()
	 * 		�� �ֽ�����-->�ַ���:�����ַ����Ĺ�����
	 * 
	 * 3.�ַ������ַ�����֮���ת��
	 * 		���ַ���-->�ַ����飺�����ַ�����toCharArray()
	 * 		���ַ�����-->�ַ����������ַ����Ĺ�����
	 * 
	 * 
	 * */
	@Test
	public void test5() {
		//1.�ַ���������������ͣ���װ��֮���ת��
		String str1 = "123";
		int i = Integer.parseInt(str1);
		System.out.println(i);
		String  str2 = String.valueOf(i);
		System.out.println(str2);
		//2.�ַ������ֽ�����֮���ת��
		String str3 = "abc123";
		byte[] b  = str3.getBytes() ; 
		for (int j = 0; j < b.length; j++) {
			System.out.print ( (char) b[j] );
		}
		System.out.println();
		String str4 = new String(b);
		System.out.println(str4);
		//3.�ַ������ַ�����֮���ת��
		String  str5 = "abc123�й���";
		char[] c = str5.toCharArray();
		for (int j = 0; j < c.length; j++) {
			System.out.print (   c[j] );
		}
		System.out.println();
		String str6 = new String(c);
		System.out.println(str6);
	}
	/*
	 * 
	 * public  String substring(int startpoing):��ȡstartpoing��ʼλ�ú����ȫ���ַ���
	 * public  String substring(int start , int end)��ȡstart��ʼλ�õ�end�������ַ���,����ҿ�,start���Դ�0��ʼ
	 * public  String replace(char oldChar ,char newchar)
	 * public  String replaceAll(String old,String new)
	 * public  String trim():ȥ����ǰ�ַ�����β���ֵĿո�,���ж��,ȥ�����
	 * public  String concat(String str):���ӵ�ǰ�ַ�����str
	 * public  String[] split(String regex) : ����regex����ǰ�ַ������,���Ϊ����ַ���, �����ַ�����
	 * */
	@Test
	public void test4() {
		String str1 = "�����й�Ƚ�������";
		String str2 = "�Ϻ��й�Ƚ���";
		String str3 = str1.substring(2);
		System.out.println(str3);
		System.out.println();
		String str4 = str1.replace("����", "�Ͼ�");
		System.out.println(str1);
		System.out.println(str4);
		String str5 = "  abc    d     ";
		String str6 = str5.trim();
		System.out.println(":"+str6+":");
		System.out.println(":"+str5+":");
		String str7 = str1.concat(str2);
		System.out.println(str7);
		String str8 = "abc*d-e7-ke";
		String [] strs  = str8.split("-");
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i]);
		}
		
	}
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
	 * String:�����ɱ���ַ����С��ײ�ʹ��char[]���
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
