package Day12_2_Exception;
//����Զ���һ���쳣��
/*1.�Զ����쳣��̳����е��쳣��
 * 2.�ṩһ�����кš�ͬʱ�ṩһ�����صĹ�����
 * 
 * */
public class MyException  extends RuntimeException {

	/**
	 * 
	 */
	  static final long serialVersionUID = 123456789L;
	public   MyException() {
		
	}
	public   MyException(String msg) {
		super(msg);
	}
	 
	
}
