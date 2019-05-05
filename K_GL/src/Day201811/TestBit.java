package Day201811;

public class TestBit {
    public static void main (String [] agrs){
        int i1 =31;
        System.out.println( i1<<27 );
        int i2 = -2;
        System.out.println(i2>>>1);
        System.out.println(i2>>2);

        System.out.println(12 & 5);
        System.out.println(12 | 5);
        System.out.println(12 ^ 5);
        System.out.println( ~ 12);
    }
}
