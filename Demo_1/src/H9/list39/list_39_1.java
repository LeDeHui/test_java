package H9.list39;
/*�ۺ�ʵս:һ�Զ�ӳ��*/

/*
 * ����
 * ����ID  number (pk)
 * ����	varchar2(50)
 * 
 * �ӷ���
 * �ӷ���ID number  (pk)
 * ����ID  number  (fk)
 * ����  varchar2(50)
 * 
 * ���ձ��Ҫ�󽫱�ṹת��Ϊ��ṹ,ͬʱ���Ի�ȡ������Ϣ
 * 		��ȡһ�������������Ϣ
 * 		���Ը��ݷ����ȡ��Ӧ�������ӷ������Ϣ

 * */
public class list_39_1 {

	public static void main(String[] args) {
		// ��һ�� ���ݽṹ���ö���
		Item item = new Item(1, "ͼ��");
//		Subitem subitemA = new Subitem(11, "�Ƽ�ͼ��");
//		Subitem subitemB = new Subitem(11, "����ͼ��");
//		subitemA.setItem(item);
//		subitemB.setItem(item);
//		item.setSubitems(new Subitem[] {subitemA,subitemB});
		Subitem subitems[] = new Subitem[] {
				new Subitem(11, "�Ƽ�ͼ��"),
				new Subitem(12, "����ͼ��"),
				new Subitem(13, "���ͼ��"),
				new Subitem(14, "Javaͼ��"),
				new Subitem(15, "C++ͼ��"),
				new Subitem(16, "C#ͼ��")
		};
		item.setSubitems(subitems);
		for (int i = 0; i < subitems.length; i++) {
			subitems[i].setItem(item);
		}
		// �ڶ���  ����Ҫ���ȡ����
		System.out.println(item.getinfo());
		for (int i = 0; i < item.getSubitems().length; i++) {
			System.out.println("\t"+item.getSubitems()[i].getinfo());
		}
	}

}

class Item {
	private long iid;
	private String title;
	private Subitem subitems [];	
	public Subitem[] getSubitems() {
		return this.subitems ;
	}
	public void setSubitems(Subitem subitems []) {
		this.subitems = subitems;
	}
	
	public Item(long iid,String title) {
		this.iid=iid;
		this.title = title;
	}
	public String getinfo() {
		return " ������Ϣ \t ����ID :  " + iid + "  �������� : " + title;
	}
}
class Subitem{
	private long sid;
	private String title;
	private Item item;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Subitem(long sid,String title) {
		this.sid=sid;
		this.title = title;
	}
	public String getinfo() {
		return "�ӷ�����Ϣ \t ����ID :  " + sid + "  �������� : " + title;
	}
}