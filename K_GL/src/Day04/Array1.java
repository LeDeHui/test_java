package Day04;
/*数组�?旦初始化，其长度不可�?*/
public class Array1 {
    public static void main(String[] args){
        int[] i = new int[]{1,2,2,3};
        int[] j = new int[10];
        for (int k = 0;k<i.length;k++){
            j[k] = i[k];
        }
        for (int k = 0;k<j.length;k++){
            System.out.println(j[k]);
        }

    }
}
