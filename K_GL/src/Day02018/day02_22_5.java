package Day02018;
import java.util.Scanner;
public class day02_22_5 {
    public static void main(String[] ages){
        System.out.println("请输入成�?");
        int i1 = new Scanner(System.in).nextInt();
        switch(i1/10){
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
                System.out.println("B");
                break;
            case 6:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
                break;
        }
    }
}
