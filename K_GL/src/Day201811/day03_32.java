package Day201811;
/*
   break   �?出循�?
    break lable  �?出到标签位置
   continue �?出当前本次循�?
    continue lable  �?出到标签位置
* */
public class day03_32 {
    public  static  void main(String[] args){
        lable:for (int i =1 ;i <= 4;i++) {
            for (int j = 1; j < 10; j++) {
                if (j % 5 == 0) {
                    System.out.print("不高�?");
                    break lable; //�?出循�?
                    //continue;// �?出当前本次循�?
                }
                System.out.println(j);
            }
        }
    }
}
