package Day11;
//�������������ģʽ
public class TestFactoryMethod {
	public static void main(String[] args) {
		IwordFactory i = new StudentWorkFactory();
		i.getWord().dowork();
		IwordFactory i1 = new TeacherWordFactory() ;
		i1.getWord().dowork();
	}

}

interface IwordFactory{
	Word getWord();
}
class StudentWorkFactory implements IwordFactory{

	@Override
	public Word getWord() {
		// TODO Auto-generated method stub
		return new StudenrWord();
	}
	
}
class TeacherWordFactory  implements IwordFactory{

	@Override
	public Word getWord() {
		// TODO Auto-generated method stub
		return new TeacherWord();
	}
	
}

interface Word {
	void dowork();
}

class StudenrWord implements Word {

	@Override
	public void dowork() {
		System.out.println("ѧ��д��ҵ");

	}

}

class TeacherWord implements Word {

	@Override
	public void dowork() {
		System.out.println("��ʦ������ҵ");

	}

}