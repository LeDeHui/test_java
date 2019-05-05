package Day02018;

/**
 * Created by ledehui on 2019/1/5.
 */
public class day03_02_26_1 {
    public static void main(String[] agrs){
        /*100之内奇数的和*/
        int sum = 0;
        for(int i1 =1 ;i1 <=100 ;i1++){
            if(i1 %2 ==1){
                sum +=i1;
            }
        }
        System.out.println(sum);
        /*100�?7的�?�数的个数及�?*/
        int count1 = 0;
        int sum1 = 0;
        for(int i2 = 1 ;i2<=100;i2++){
            if(i2%7 == 0 ){
                sum1 += i2;
                count1++;
            }
        }
        System.out.println("7倍数的个数有�?"+ count1
                + " ;7倍数的和为："+sum1);

        /*输出�?有的水仙花数
        * 153 = 1*1*1+5*5*5+3*3*3
        * */
        for (int i3 = 100; i3<=999;i3++){
            int j1 = i3/100;
            int j2 = i3%100/10;
            int j3 = i3%10;
            if( j1*j1*j1+j2*j2*j2+j3*j3*j3 == i3){
                System.out.println(i3);
            }
        }
    }
}
