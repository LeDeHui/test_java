package Day201811;
/*输入 �? �? 日计算该天为全年的第几天*/
import java.util.Scanner;
public class day02_23_4 {
    public static void main(String[] ages){
        System.out.println("请输入年�?");
        int i1 = new Scanner(System.in).nextInt();
        System.out.println("请输入月�?");
        int i2 = new Scanner(System.in).nextInt();
        System.out.println("请输入日�?");
        int i3 = new Scanner(System.in).nextInt();
        int sum = 0;
        switch (i2){
            case 12:
                sum +=30;
            case 11:
                sum +=31;
            case 10:
                sum +=30;
            case 9:
                sum +=31;
            case 8:
                sum +=31;
            case 7:
                sum +=30;
            case 6:
                sum +=31;
            case 5:
                sum +=30;
            case 4:
                sum +=31;
            case 3:
            {if ((i1%4 == 0 && i1%100 !=0 ) || ( i1%400 ==0)){
                sum +=29;/*闰年*/
            }
            else{
                sum +=28;/*非闰�?*/
            }
            }
            case 2:

                sum +=31;
            case 1:
                sum +=i3;
        }
        System.out.println(sum);
    }
}
