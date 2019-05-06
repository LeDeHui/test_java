package Day18_2_StringBuffer;

import org.junit.Test;

/*
 * java.lang.StringBuffer: 可变的字符序列，可以对字符串内容进行增删
 * java.lang.StringBuilder:可变的字符序列,1.5版本加入的。线程不安全的。不考虑线程安全的情况下，效率高于StringBuffer
 * */
/*
 *  StringBuffer append(String s),   
 *  StringBuffer append(int n) ,  
	StringBuffer append(Object o) ,  
	StringBuffer append(char n),
	StringBuffer append(long n),  
	StringBuffer append(boolean n),
	
	StringBuffer insert(int index, String str) :指定位置index插入str
	public StringBuffer reverse() ：反转此StringBuffer
	StringBuffer delete(int startIndex, int endIndex)： 删除startIndex位置开始 到 endIndex位置结束
	public char charAt(int n )：取指定位置的字符
	public void setCharAt(int n ,char ch)：修改指定位置n的字符为ch
	StringBuffer replace( int startIndex ,int endIndex, String str) ：修改多个字符，开始startIndex到endIndex结束，修改为str
	public int indexOf(String str)：
	public String substring(int start,int end)
	public int length()


 *	总结：添加：append()
 *		删除：delete(int startIndex, int endIndex)
 *		插入：insert(int index, String str)
 *		反转：reverse()
 *		查：charAt(int n )
 *		修改：setCharAt(int n ,char ch)
 *		
 * */

public class TestStringBuffer {
	/*
	 * 对比String，StringBuffer,StringBuilder三者的效率
	 * 效率从高到底StringBuilder，StringBuffer，String
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
		System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			builder.append(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			text = text + i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("String的执行时间：" + (endTime - startTime));
	}

	@Test
	public void test1() {
		StringBuffer sb = new StringBuffer();
		sb.append("abc").append("123");
		System.out.println(sb);

	}
}
