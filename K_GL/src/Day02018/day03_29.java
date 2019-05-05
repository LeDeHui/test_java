package Day02018;
/*
循环嵌套
99乘法�?
*/
import java.util.Scanner;
public class day03_29 {
    public static void main (String[] ages){
        Scanner s  = new Scanner(System.in);

        for (int i =1 ;i<=9;i++){
            for (int j  = 1 ;j <= i ;j++){
                System.out.print( i + " * "+ j + " = "+ i*j +"\t");
            }
            System.out.println();
        }/*99乘法�?*/
        /*菱形*/
        System.out.println("请输入菱形大�?");
        int is = s.nextInt();
        for(int i=1;i<is;i++){
            for (int j = 1 ;j<= is-1  ;j++){
                if (i+j >= is){
                System.out.print("* ");}
                else
                {System.out.print(" ");}
            }
            System.out.println();}

            for(int i=1;i<=is-1;i++){
                for (int j = 1 ;j<= is-1  ;j++){
                   if (i >= j){
                       System.out.print(" ");
                   }else{
                       System.out.print("* ");
                   }
                }
                System.out.println();
            }

    }
}
