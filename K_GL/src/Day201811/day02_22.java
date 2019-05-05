/*switch  case  用法
* switch(变量){
* case �?1:
*   语句1;
*   break;
* case �?2:
*   语句2;
*   break;
* case �?3:
*   语句3;
*   break;
* default:
*   语句N;
*   break;
* }
* */
package Day201811;
import java.util.Scanner;
public class day02_22 {
    public static void main(String[] args){
        System.out.println("请输入你的幸运数�?");
        int i1 = new Scanner(System.in).nextInt();
        switch (i1){
            case 1:{System.out.println(1);
                System.out.println(1); }
                break;
            case 2:{System.out.println(22);
                System.out.println(1);}
                break;
            default:{System.out.println("xx00");
                System.out.println(1);}
                break;
        }
        System.out.println("请输入你的字符串");
        String s1 = new Scanner(System.in).next();
        switch (s1){
            case "a":
            {System.out.println(1);}
            break;
            case "b":
            {System.out.println(3);}
            break;
            case "asd":
            {System.out.println(31);}
            break;
             default:
                 System.out.println(22);
                 break;
        }
    }
}
