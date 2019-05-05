package Day02018;
//赋�?�运算符
public class GetValues {
    public static void main  (String[] args){
        int i1 = 5;
        i1 += 81 ;
        System.out.println(i1);

        boolean b1 = false;
        if (b1 == true   )
            System.out.println("YES");
        else
            System.out.println("NO");

        int i2 = 1;
        i2 *= 0.1;
        System.out.println(i2);
        i2 ++;
        System.out.println(i2);

        boolean  a = true;
        // boolean  a = false;
        //boolean  b =  true;
        boolean b = false ;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(!a);
        System.out.println(a^b);
        System.out.println(a&&b);
        System.out.println(a||b);

        int i11 = 10;
        if (b & (i11++) > 0 ){
            System.out.println("YES");
        }else {
            System.out.println("No");
        }
        System.out.println(i11);
        //& && 的区�?
        //& 计算   &&左端为false 时右端不计算
        int i12 = 10;
        if (b && (i12++) > 0 ){
            System.out.println("YES");
        }else {
            System.out.println("No");
        }
        System.out.println(i12);

    }
}
