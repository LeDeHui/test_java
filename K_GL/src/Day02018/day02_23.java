package Day02018;
/*键盘输入字母
abcde大写，其他other
* */
import  java.util.Scanner;
public class day02_23 {
    public static void main(String[] ages){
        System.out.println("请输入一个小写字�?");
        String s1 = new Scanner(System.in).next();
        switch (s1){
            case "a":
                System.out.println("A");
                break;
            case "b":
                System.out.println("B");
                break;
            case "c":
                System.out.println("C");
                break;
            case "d":
                System.out.println("D");
                break;
            case "e":
                System.out.println("E");
                default:
                    System.out.println("other");
                    break;
        }
    }
}
