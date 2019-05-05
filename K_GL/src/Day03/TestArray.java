package Day03;

public class TestArray {
    public static void main(String[] args){
        String[] namess = new String[]{"aa","bb"};
        //1.定义数组
        //声明
        String[] names;
        int[] scores;
        //2.初始�?
        //静�?�初始化：初始化数组 �? 数组元素赋�?? 同时进行
        names = new String[]{"�?","�?","�?"};
        //动�?�初始化：初始化数组 �? 数组元素赋�?? 分开进行
        scores = new int[4];
        scores[0]=  87;
        scores[1] = 89;
        scores[2] = 98;
        scores[3] = 99;
        //如何调用相应的数组元�?  通过数组元素的下角标方式调用
        //下角标从0�?始，到n-1结束，n表示数组的长�?
        //3.数组的长�?  通过数组的length属�?��??
        System.out.println(scores.length);
        System.out.println(names.length);
        //4.如何遍历数组元素
        for (int i = 0 ; i < names.length ; i++){
            System.out.print(names[i] + " ");
        }
        System.out.println();
        for (int i = 0 ;i < scores.length;i++){
            System.out.print(scores[i] + " ");
        }
    }
}
