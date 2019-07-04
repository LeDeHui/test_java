package H9.list40;
 

/*�ۺ�ʵս:��Զ�ӳ��*/
/*
 * �û���Ϣ
 * �û�ID  varchar2 (pk)
 * ����  varchar
 * 
 * ��Ʒ
 * ��ƷID number  (pk)
 * ��Ʒ���� varchar
 * ��Ʒ�۸� number
 * 
 * ���ʼ�¼
 * �û�ID varchar  (fk1)
 * ��ƷID number  (fk2)
 * 
 * 
 * �����ϵĽṹ ת��Ϊ��ṹ,ͬʱ���Ի�ȡ������Ϣ
 * 
 * 	��ȡһ���û����ʵ�������Ʒ����ϸ��Ϣ
 * 	��ȡһ����Ʒ���������ȫ���û���Ϣ
 * */
/*
 * ���ڴ�ʱ�ĳ���ֻ��Ҫȥ������������Ƽ���,Ҳ����˵,�����м�ķ��ʼ�¼��Ϣ��Ҫ�������ת��,ֻ��Ҫ���������༴��
 * */
public class list_40_1 {

	public static void main(String[] args) {
		// ��һ�� ���ݽṹ���ö���
		Member memberA = new Member("mldn", "����");
		Member memberB = new Member("Java", "����");
		Product productA = new Product(1, "book-java", 23.0);
		Product productB = new Product(2, "book-xml", 25.0);
		Product productC = new Product(3, "book-C++", 24.0);
		memberA.setProducts(new Product[] {productA,productB,productC});
		memberB.setProducts(new Product[] {productA });
		productA.setMembers( new Member[] {memberA,memberB});
		productB.setMembers( new Member[] {memberA });
		productC.setMembers( new Member[] {memberA });
		// �ڶ���  ����Ҫ���ȡ����
		System.out.println("---------������Ʒ�鿴����û���Ϣ---------");
		System.out.println( productA.getinfo() );
		for (int i = 0; i < productA.getMembers().length; i++) {
			System.out.println("\t"+ productA.getMembers()[i].getinfo());
			
		}
		System.out.println("---------�����û��鿴�����Ʒ��Ϣ---------");
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
		return "�û���Ϣ  -- �û�ID : " + this.mid + "  �û����� : " + this.name;
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
		return "��Ʒ��Ϣ  -- ��ƷID : " + this.pid + "  ��Ʒ���� : " + this.pname + "  ��Ʒ�۸� : " + this.price;
	}
}

