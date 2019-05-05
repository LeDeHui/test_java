package Day02019;
/*完数 数字等于因子之和
6 =1+2+3*/
public class Test_Wanshu {
    public  static void main(String[] args){
        int sum = 0;
        for(int i = 1 ;i <= 1000;i++){
            for (int j = 1 ;j <  i; j++){
                if ( i%j == 0){
                    sum += j;
                }
            }
            if (sum == i){
                System.out.println("完数�?"+ i);
            }
            sum = 0;

        }
    }
}
