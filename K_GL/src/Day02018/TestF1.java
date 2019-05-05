package Day02018;

import java.util.Scanner;

public class TestF1 {
    public static void main (String [] ages){
        System.out.println("输入分数");
        Scanner s = new Scanner(System.in);
        int score = s.nextInt();
        if (score == 100){
            System.out.println("棒棒哒，你的分数�?"+score);
        }
        else if  (score>=60  && score <= 80){
            System.out.println("也不错，分数"+score);
        }else {
            if (score > 80){
                System.out.println(score);
            }else{
            System.out.println("加油"+score);}
        }
    }
}
