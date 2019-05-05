package Day201811;

/*键盘输入三个�?
* 比较三个数的大小
* */
import java.util.Scanner;

public class Test_3 {
    public static void  main (String [] ages) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入第�?个输");
        int num1 = s.nextInt();
        System.out.println("请输入第二个�?");
        int num2 = s.nextInt();
        System.out.println("请输入第三个�?");
        int num3 = s.nextInt();
        if (num1 >num2){
            if(num3>num1){
                System.out.println(num3 +">" + num1 +">"+ num2);
            }else if(num2>num3){
                System.out.println( num1 +">"+ num2 + ">" +num3 );
            } else {
                System.out.println( num1 + ">"+num3 +">"+ num2 );
            }

        }else{
            if(num3>num2){
                System.out.println(num3 +">" + num2 +">"+ num1);
            }else if(num1>num3){
                System.out.println( num2 +">"+ num1 + ">" +num3 );
            } else {
                System.out.println( num2 + ">"+num3 +">"+ num1 );
            }
        }
    }
}
