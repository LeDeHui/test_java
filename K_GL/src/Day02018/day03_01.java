package Day02018;

public class day03_01 {
    public static void main(String[] agrs){
        for(int i =0 ;i<4;i++){
            System.out.println("HelloWorld " + i);
            System.out.println("Hello " + (i+1));
        }
        int sum = 0;
        int count =0;
        for (int i1 = 1;i1 <=100;i1++){
            if(i1%2==0){
                System.out.print (i1 + " ");
                sum +=i1;
                count++;
            }

        }System.out.print(sum+"  ");
        System.out.print(count);
        }
}
