package Day04;

public class TestArraySum {
    public static void main(String[] args){
        int sum1 = 0;
        int sum2 = 0;
        int[][] arr = new int[][]{{3,8,2},{2,7},{9,0,1,6}};
        for (int i = 0;i<arr.length;i++){
            for(int j = 0 ;j < arr[i].length;j++){
                System.out.print(arr[i][j] + "\t");
                sum1 += arr[i][j];
            }
            System.out.println();
        }
        System.out.println(sum1);


    }
}
