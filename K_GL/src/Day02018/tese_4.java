package Day02018;
import java.util.Scanner;
public class tese_4 {
    public static  void main(String[] ages){
        System.out.println("身高（CM�?");
        int SG = new Scanner(System.in).nextInt();
        System.out.println("财富（千万）");
        double  CF = new Scanner(System.in).nextDouble();
        System.out.println("帅否（true/false�?");
        boolean SF = new Scanner(System.in).nextBoolean() ;
        if ( (SG > 180 ) & (CF > 10.0) & (SF == true)   ){
            System.out.println("我一定嫁给你");
        }else if ((SG > 180 ) | (CF > 10.0) | (SF == true)){
            System.out.println("考虑考虑");
        }else {
            System.out.println("不嫁不嫁");
        }


    }
}
