package Day02018;
/*三元运算�?   */
public class TestSanY {
    public static void main(String[] agrs){
        int i1 = 10;
        int i2 = 20;
        System.out.println(  (i1>i2)?i1:i2  );

        int  a = 11;
        int b = 8;
        int c = 7;
        System.out.println(  (a>b)?  ((a>c)? "a�?�?":"c�?�?") :((b>c)?"b�?�?":"c�?�?" ));
    }
}
