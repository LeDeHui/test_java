package Day04;
import java.util.Scanner;
public class test1 {
    public static void main(String[] agrs){
        System.out.println("请输入你�?要的数组长度");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] i = new int[num];
        for (int j = 0;j<i.length;j++){
            System.out.println("请输入您的第"+(j+1)+"个数");
            int k = s.nextInt();
            i[j] = k;
        }
        System.out.println("您输入的数组为：");
        for (int j = 0;j<i.length;j++){
            System.out.print( i[j] +" ");
        }

    }
}
