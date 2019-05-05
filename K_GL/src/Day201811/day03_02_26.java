package Day201811;

/**
 * Created by ledehui on 2019/1/5.
 */
public class day03_02_26 {
    public static void main(String[] agrs){
        for (int i = 1;i<=150;i++){
            System.out.print(i);
            if (i%3 == 0 ){
                System.out.print(" foo");
            }
            if (i%5 == 0){
                System.out.print(" biz");
            }
            if (i%7 == 0){
                System.out.print(" baz");
            }
            System.out.println();

        }
    }
}
