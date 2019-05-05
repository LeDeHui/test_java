package Day04;

public class Ayyay2_1 {
    public static void main(String[] agrs) {
        int[][] scores2;
        scores2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8}, {9}};
        //遍历二维数组
        for(int i1 = 0 ;i1<scores2.length;i1++){
            for (int j = 0;j <scores2[i1].length;j++){
                System.out.print(scores2[i1][j] + " ");
            }
            System.out.println();
        }
    }
}
