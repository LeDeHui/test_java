package Day09;

import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;

/*
 * 利用Vector代替数组处理，从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类Java.util.Vectoe可以根据
 * 创建Vector对象：Vector v = new Vector（）;
 * 给向量添加元素：v.addElement（obj）；//obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的角标是0，返回值是Object类型的。
 * 计算向量的长度：v.size()；
 * 若与最高分相差10分以内A。20，B。30，C,其他，D     
 * */
public class TestScore {
	public static void main(String[] args) {
		//1.创建Scanner的对象，提示从键盘输入学生的成绩，以负数结束
		Scanner s = new Scanner(System.in);
		System.out.println("请输入学生的成绩（负数结束输入）");
		//2.for(;;),从键盘依次获取成绩，并填入Vector v = new Vector（）创建的对象V中，v.addElement（obj）
		//3.求出所有输入的成绩中的最高分
		Vector v = new Vector();
		int maxscore = 0;
		for (;;)
		{
			int score = s.nextInt();
			if (score <0) {
				break;
			}
			//获取最高分
			if (maxscore < score) {
				maxscore = score;
			}
			//成绩存放V中
			v.addElement(score);
			System.out.println("请输入学生的成绩（负数结束输入）");
			
		}
		
		//4. 通过v.elementAt(i); 依次获取V中的元素，并判断分数等级并输出
		
		for (int i = 0 ;i<v.size();i++) 
		{
			Integer score  = (Integer)v.elementAt(i);
			char levle  ;
			if (maxscore - score  <=10) {
				levle = 'A';
			}else if (maxscore - score <=20) {
				levle = 'B';
			}
			else if (maxscore - score <=30) {
				levle = 'C';
			}else {
				levle = 'D';
			}
			System.out.println("第"+(i+1)+"名学生成绩为"+score+"等级为:" +levle);
		}
		
		
	}

}
