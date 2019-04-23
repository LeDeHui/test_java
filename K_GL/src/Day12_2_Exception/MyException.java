package Day12_2_Exception;
//如何自定义一个异常类
/*1.自定义异常类继承现有的异常类
 * 2.提供一个序列号。同时提供一个重载的构造器
 * 
 * */
public class MyException  extends RuntimeException {

	 
	  static final long serialVersionUID = 123456789L;
	public   MyException() {
		
	}
	public   MyException(String msg) {
		super(msg);
	}
	 
	
}
