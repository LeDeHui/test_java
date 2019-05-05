package Day201811;
import java.util.Scanner;
/*键盘输入成绩
大于60及格
小于60不及�?
*/
public class day02_23_2 {
    public static void  main (String[] agrs){
        System.out.println("输入分数");
        int i1 = new Scanner(System.in).nextInt();
        /*方法1*/
        if (i1>=60){
            System.out.println("及格");
        }else{
            System.out.println("不及�?");
        }
        /*方法2*/
        /*分数/60  大于60 等于1及格 小于60 等于0不及�?*/
        switch (i1/60){
            case 1:
                System.out.println("及格");
                break;
            case 0:
                System.out.println("不及�?");
                break;

        }
    }
}
