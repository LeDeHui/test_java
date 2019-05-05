package Day04;
import java.util.Scanner;
public class test3 {
    public static void main(String[] agrs){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入学生数�?");
        int i1 = s.nextInt();
        int[] i2 = new int[i1];
        for (int j= 0 ;j<i2.length;j++){
            System.out.println("请输入第"+(j+1) +"个学生的成绩");
            int j2 = s.nextInt();
            i2[j] = j2;
        }
        int max = i2[0];
        for (int j = 1;j<i2.length;j++){
            if(max < i2[j]){
                max = i2[j];
            }
        }
        System.out.println("�?高分为："+max );
        char level;
        for (int j = 0;j<i2.length;j++){
            if (i2[j]>=max-10 ){
                level = 'A';
            }else if (i2[j]>=max-20 ){
                level = 'B';
            }else if(i2[j]>=max-30 ){
                level = 'C';
            }else {
                level = 'D';
            }

            System.out.println("学生编号 "+(j+1)+" 的成�? "+i2[j]+" 在本次等级为 " + level);

        }
    }
}
