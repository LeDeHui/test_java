package Day09;

import org.junit.jupiter.api.Test;

/*Junit��Ԫ������
 * 1.��ǰ������--�Ҽ�build path-add libraries-Junit
 * 2.�������У�����һ���ղε��޷���ֵ�ķ������磺public void test1()���ڴ���Ĳ��ԣ�����ǰ������@Test
 * 3.����mport org.junit.jupiter.api.Test;
 * 4.��test1���������У����д����д
 * 5.���ԣ�˫�����������Ҽ�run as-junit test����
 * 
 * */
public class TestJunit {
	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str);
	}

	@Test
	public void test1() {
		String str = "aa";
		System.out.println(str);
		m1();
	}

	public void m1() {
		System.out.println("hello");
	}
}
