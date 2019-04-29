package Day14_1_test1;

import java.util.List;
import java.util.HashMap;

/*
 * 创建DAO类的额对象
 * 分别调用其save，get，update，list，delete方法操作User对象
 * 使用
 * */
public class TestDAO {
	public static void main(String[] args) {
		DAO<User> dao = new DAO<User>();
		dao.map= new HashMap<String, User>();
		dao.save("1001", new User(1,32,"Le"));
		dao.save("1002", new User(2,34,"De"));
		dao.save("1003", new User(3,23,"Hui"));
		User user = dao.get("1002");
		System.out.println(user);		
		dao.update("1002", new User(4,45,"Yuan"));
		dao.delete("1003");
		List<User>  list = dao.list();
		System.out.println(list);
		
		
		 
	}

}
