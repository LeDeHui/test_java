package Day02018;

/**
 * Created by ledehui on 2019/1/5.
 * while 循环
 * 举例�?
 * 100以内的偶�?
 *   do...while 循环
 *   举例�?
 *   100以内的偶�?
 */
public class day03_27 {
    public static void main(String[] agrs){
        int i1 = 1;
        while(i1<=100){
            if (i1%2 ==0){
                System.out.println(i1);
            }
            i1++;
        }

    int j = 0;
        do {
            if (j%2 ==0){
            System.out.println(j);}
            j++;}
        while(j <=100);
        System.out.println(i1);
        System.out.println(j);
    }
}
