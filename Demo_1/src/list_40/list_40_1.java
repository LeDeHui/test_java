package list_40;
/*综合实战:多对多映射*/
/*
 * 用户信息
 * 用户ID  varchar2 (pk)
 * 姓名  varchar
 * 
 * 商品
 * 商品ID number  (pk)
 * 商品名称 varchar
 * 商品价格 number
 * 
 * 访问记录
 * 用户ID varchar  (fk1)
 * 商品ID number  (fk2)
 * 
 * 
 * 将以上的结构 转换为类结构,同时可以获取如下信息
 * 
 * 	获取一个用户访问的所有商品的详细信息
 * 	获取一个商品被浏览过的全部用户信息
 * */
/*
 * 对于此时的程序只需要去考虑是体表的设计即可,也就是说,对于中间的访问记录信息表不要求你进行转换,只需要定义两个类即可
 * */
public class list_40_1 {

	public static void main(String[] args) {
		// 第一步 根据结构设置对象
		Member memberA = new Member("mldn", "张三");
		Member memberB = new Member("Java", "李四");
		Product productA = new Product(1, "book-java", 23.0);
		Product productB = new Product(2, "book-xml", 25.0);
		Product productC = new Product(3, "book-C++", 24.0);
		memberA.setProducts(new Product[] {productA,productB,productC});
		memberB.setProducts(new Product[] {productA });
		productA.setMembers( new Member[] {memberA,memberB});
		productB.setMembers( new Member[] {memberA });
		productC.setMembers( new Member[] {memberA });
		// 第二补  根据要求获取数据
		System.out.println("---------根据用户查看浏览商品信息---------");
		System.out.println( productA.getinfo() );
		for (int i = 0; i < productA.getMembers().length; i++) {
			System.out.println("\t"+ productA.getMembers()[i].getinfo());
			
		}
		System.out.println("---------根据商品查看浏览用户信息---------");
		 System.out.println(memberA.getinfo());
		 for (int i = 0; i < memberA.getProducts().length; i++) {
			System.out.println("\t" + memberA.getProducts()[i].getinfo());
		}

	}

}
class Member{
	private String mid;
	private String name;
	private Product products[];

	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	
	public Member(String mid, String name) {
		super();
		this.mid = mid;
		this.name = name;
	}
	public String getinfo() {
		return "用户信息  -- 用户ID : " + this.mid + "  用户名称 : " + this.name;
	}
} 

class Product{
	private long pid;
	private String pname;
	private double price;
	private Member members[];
	
	public Member[] getMembers() {
		return members;
	}
	public void setMembers(Member[] members) {
		this.members = members;
	}
	
	public Product(long pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	public String getinfo() {
		return "商品信息  -- 商品ID : " + this.pid + "  商品名称 : " + this.pname + "  商品价格 : " + this.price;
	}
}

