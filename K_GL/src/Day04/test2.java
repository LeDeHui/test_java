package Day04;

public class test2 {
    public static void main(String[] agrs){
        Ayyay2  d = new Ayyay2();
        for(int i = 0 ;i< d.t.length  ;i++  ){
            System.out.println(d.t[i]);
            //System.out.println(d.t.clone());
        }
        d.t[0] = true;
        d.t[1] = true;
        d.t[2] = true;
        for(int i = 0 ;i< d.t.length  ;i++  ){
            System.out.println(d.t[i]);
            //System.out.println(d.t.clone());
        }
    }
}
class Ayyay2{
    boolean[] t = new boolean[3];
}