package Day04;

import javax.annotation.processing.SupportedSourceVersion;

public class Test_Array {
    public static void main(String[] ages){
        //对于基于基本数据类型建立的数�?
        //byte  short int long float duble char string
        //1.对于 byte int long  short 而言，默认�?�为0
        int [] i1 = new int[4];
        i1[0] = 89;
        i1[3] = 90;
        for (int j=0;j<i1.length;j++){
            System.out.println(i1[j]);
        }
        //对于2.float  duble而言。默认�?�为0.0
        float [] i11 = new float[4];
        i11[0] = 89f;
        i11[3] = 90f;
        for (int j=0;j<i11.length;j++){
            System.out.println(i11[j]);
        }
        //3.对于 char 类型而言，默认为空格
        char [] c1 = new char[3];
        for (int j=0;j<c1.length;j++){
            System.out.println(c1[j]);
        }
        //4.对于 boolean 而言默认为false
        boolean [] b1 = new boolean[2];
        for (int j=0;j<b1.length;j++){
            System.out.println(b1[j]);
        }
        //5.对于引用类型的变量构成的数组而言。默认�?�为null
        String[] strs = new String[4];
        strs[0] = "aa";
        strs[1] = "bb";
        //strs[2] = "cc";
        strs[3] = "dd";
        //遍历数组的元�?
        for (int i   = 0 ;i <strs.length;i++){
            System.out.println(strs[i]);
        }
        Person[] pers = new Person[3];
        for (int i   = 0 ;i <pers.length;i++){
            System.out.println(pers[i]);
        }
        //关于数组在内存的结构
        int[] myInt =new int[] {12,2,3,6,7};
    }
}
class Person{        }
