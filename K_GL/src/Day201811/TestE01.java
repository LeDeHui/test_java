package Day201811;

public class TestE01 {
    public static void main(String[] agrs){
        int m = 12;
        int n = 5;
        System.out.println("m:"+ m + " n:"+ n);
        /*
        int temp = n;
        n = m;
        m = temp;
        System.out.println("m:"+ m + " n:"+ n);
        */
        /*
        m = m + n;
        n = m - n;
        m = m - n;
        System.out.println("m:"+ m + " n:"+ n);
        */
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
        System.out.println("m:"+ m + " n:"+ n);

        //16 进制输出
        //60
        int i =60;
        int temp_a = i & 15 ; //获取I的最�?4位相对应的�??
        String   temp_b =  (temp_a<=9)?temp_a+"":(char)(temp_a -10 +'a')+"";
        System.out.println(temp_b);

        i  = i>> 4;
        int temp_a1 = i & 15 ; //获取I的最�?4位相对应的�??
        String   temp_b1 =  (temp_a1<=9)?temp_a1+"":(char)(temp_a1 -10 +'a')+"";
        System.out.println(temp_b1);

        /*String binary = Integer.toBinaryString(i);
        System.out.println(binary);
        String hex = Integer.toHexString(i);
        System.out.println(hex);
        */
        }
}
