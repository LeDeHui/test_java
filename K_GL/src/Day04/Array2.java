package Day04;

public class Array2 {
    public static void main(String[] agrs){
        int[] scores1 = new int[10];
        int[][] scores2 ;
        String[][] names;
        //1.二维数组的初始化
        //静�?�初始化
        scores2 = new int[][]{{1,2,3},{4,5,6},{7,8},{9}};
        //动�?�初始化
        /*动�?�初始化方法1*/
        names = new String[3][2];
        /*动�?�初始化方法2*/
        names = new String[3][];
        names[0] = new String[2];
        names[1] = new String[3];
        names[2] = new String[1];
        /*错误的初始化
         names = new String[][]
         names = new String[][4]
        */
        //2.如何来引用具体的某一个元�?
        int[][] i1 =  new int[3][2];
        i1[0][1] = 90;
        i1[1][0] = 100;
        System.out.println(i1.length);
        System.out.println(i1[0].length);
        for (int i = 0 ;i < 3;i++){
            for (int j = 0 ;j < 2;j++){
                System.out.print(i1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
