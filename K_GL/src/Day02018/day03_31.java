package Day02018;
/*
* 100以内的质�?
* */
import java.util.Scanner;
public class day03_31 {
    public static void main(String[] agrs){
        long start = System.currentTimeMillis();//系统毫秒�?
        boolean flag = false;
        for (int i = 2 ;i<=100000;i++){
            //int sum = 0;
            for (int j = 2 ;j<= Math.sqrt(i)  ; j++){
                //Math.sqrt(i)  �?根号
                if(i%j == 0){
                    flag = true;
                    break;
                }
            }
           // if (flag == false) {
            if(!flag){
               // System.out.println(i);
            }
            flag = false;
        }
        System.out.println(  System.currentTimeMillis() -start);
        //结束时间-�?始时�? = 程序执行时间

    }
}
