package Day09;

import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;

/*
 * ����Vector�������鴦���Ӽ��̶���ѧ���ɼ����Ը�������������������ҳ���߷֣������ѧ���ɼ��ȼ�
 * ��ʾ������һ�����������Ⱦ͹̶����䣬�����ڴ�������ǰ����Ҫ֪�����ĳ��ȡ���������Java.util.Vectoe���Ը���
 * ����Vector����Vector v = new Vector����;
 * ���������Ԫ�أ�v.addElement��obj����//obj�����Ƕ���
 * ȡ�������е�Ԫ�أ�Object obj=v.elementAt(0);
 * ע���һ��Ԫ�صĽǱ���0������ֵ��Object���͵ġ�
 * ���������ĳ��ȣ�v.size()��
 * ������߷����10������A��20��B��30��C,������D     
 * */
public class TestScore {
	public static void main(String[] args) {
		//1.����Scanner�Ķ�����ʾ�Ӽ�������ѧ���ĳɼ����Ը�������
		Scanner s = new Scanner(System.in);
		System.out.println("������ѧ���ĳɼ��������������룩");
		//2.for(;;),�Ӽ������λ�ȡ�ɼ���������Vector v = new Vector���������Ķ���V�У�v.addElement��obj��
		//3.�����������ĳɼ��е���߷�
		Vector v = new Vector();
		int maxscore = 0;
		for (;;)
		{
			int score = s.nextInt();
			if (score <0) {
				break;
			}
			//��ȡ��߷�
			if (maxscore < score) {
				maxscore = score;
			}
			//�ɼ����V��
			v.addElement(score);
			System.out.println("������ѧ���ĳɼ��������������룩");
			
		}
		
		//4. ͨ��v.elementAt(i); ���λ�ȡV�е�Ԫ�أ����жϷ����ȼ������
		
		for (int i = 0 ;i<v.size();i++) 
		{
			Integer score  = (Integer)v.elementAt(i);
			char levle  ;
			if (maxscore - score  <=10) {
				levle = 'A';
			}else if (maxscore - score <=20) {
				levle = 'B';
			}
			else if (maxscore - score <=30) {
				levle = 'C';
			}else {
				levle = 'D';
			}
			System.out.println("��"+(i+1)+"��ѧ���ɼ�Ϊ"+score+"�ȼ�Ϊ:" +levle);
		}
		
		
	}

}
