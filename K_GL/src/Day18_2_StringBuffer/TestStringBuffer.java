package Day18_2_StringBuffer;

import org.junit.Test;

/*
 * java.lang.StringBuffer: �ɱ���ַ����У����Զ��ַ������ݽ�����ɾ
 * java.lang.StringBuilder:�ɱ���ַ�����,1.5�汾����ġ��̲߳���ȫ�ġ��������̰߳�ȫ������£�Ч�ʸ���StringBuffer
 * */
/*
 *  StringBuffer append(String s),   
 *  StringBuffer append(int n) ,  
	StringBuffer append(Object o) ,  
	StringBuffer append(char n),
	StringBuffer append(long n),  
	StringBuffer append(boolean n),
	
	StringBuffer insert(int index, String str) :ָ��λ��index����str
	public StringBuffer reverse() ����ת��StringBuffer
	StringBuffer delete(int startIndex, int endIndex)�� ɾ��startIndexλ�ÿ�ʼ �� endIndexλ�ý���
	public char charAt(int n )��ȡָ��λ�õ��ַ�
	public void setCharAt(int n ,char ch)���޸�ָ��λ��n���ַ�Ϊch
	StringBuffer replace( int startIndex ,int endIndex, String str) ���޸Ķ���ַ�����ʼstartIndex��endIndex�������޸�Ϊstr
	public int indexOf(String str)��
	public String substring(int start,int end)
	public int length()


 *	�ܽ᣺��ӣ�append()
 *		ɾ����delete(int startIndex, int endIndex)
 *		���룺insert(int index, String str)
 *		��ת��reverse()
 *		�飺charAt(int n )
 *		�޸ģ�setCharAt(int n ,char ch)
 *		
 * */

public class TestStringBuffer {
	/*
	 * �Ա�String��StringBuffer,StringBuilder���ߵ�Ч��
	 * Ч�ʴӸߵ���StringBuilder��StringBuffer��String
	 * */
	@Test
	public void test3() {
		String text = "";
		long startTime = 0L;
		long endTime = 0L;
		StringBuffer buffer = new StringBuffer("");
		StringBuilder builder = new StringBuilder("");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			buffer.append(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer��ִ��ʱ�䣺" + (endTime - startTime));
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			builder.append(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder��ִ��ʱ�䣺" + (endTime - startTime));
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			text = text + i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("String��ִ��ʱ�䣺" + (endTime - startTime));
	}

	@Test
	public void test1() {
		StringBuffer sb = new StringBuffer();
		sb.append("abc").append("123");
		System.out.println(sb);

	}
}
