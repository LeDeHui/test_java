package Day02018;
/*
* 练习
* 99乘法�?
* */
import java.util.Scanner;

public class day03_30 {
    public static void main (String[] ages) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }
}
