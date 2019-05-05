package Day02018;
/*
* 输入月份，输出季�?
* 345春季
* 678夏季
* 91011秋季
* 1212冬季
* */
import  java.util.Scanner;
public class day02_23_3 {
    public static void main(String[] ages){
        System.out.println("请输入月�?");
        int i1  = new Scanner(System.in).nextInt();
        switch (i1){
            case 3:
            case 4:
            case 5:
            {System.out.println("春季");}
            break;
            case 6:
            case 7:
            case 8:
            {System.out.println("夏季");};
            break;
            case 9:
            case 10:
            case 11:
            {System.out.println("秋季");};
            break;
            case 12:
            case 1:
            case 2:
            {System.out.println("冬季");};
            break;
        }
    }
}
