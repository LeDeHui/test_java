package Day2019_test;
import java.util.Scanner;
public class Test_F001 {
    public static void main (String[] agrs){
       // int i1 = new Scanner(System.in).nextInt();

        int day2 = 0;
        for( int i2 = 3000;i2 > 5;i2 /=2){
            day2 ++;
            System.out.println(i2);
        }
        System.out.println(day2);
    }
}
