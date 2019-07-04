package list_39;
/*综合实战:一对多映射*/

/*
 * 分类
 * 分类ID  number (pk)
 * 名称	varchar2(50)
 * 
 * 子分类
 * 子分类ID number  (pk)
 * 分类ID  number  (fk)
 * 名称  varchar2(50)
 * 
 * 按照表的要求将表结构转换为类结构,同时可以获取如下信息
 * 		获取一个分类的完整信息
 * 		可以根据分类获取对应的所有子分类的信息

 * */
public class list_39_1 {

	public static void main(String[] args) {
		// 第一步 根据结构设置对象
		Item item = new Item(1, "图书");
//		Subitem subitemA = new Subitem(11, "科技图书");
//		Subitem subitemB = new Subitem(11, "人文图书");
//		subitemA.setItem(item);
//		subitemB.setItem(item);
//		item.setSubitems(new Subitem[] {subitemA,subitemB});
		Subitem subitems[] = new Subitem[] {
				new Subitem(11, "科技图书"),
				new Subitem(12, "人文图书"),
				new Subitem(13, "编程图书"),
				new Subitem(14, "Java图书"),
				new Subitem(15, "C++图书"),
				new Subitem(16, "C#图书")
		};
		item.setSubitems(subitems);
		for (int i = 0; i < subitems.length; i++) {
			subitems[i].setItem(item);
		}
		// 第二补  根据要求获取数据
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
		return " 分类信息 \t 分类ID :  " + iid + "  分类名称 : " + title;
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
		return "子分类信息 \t 分类ID :  " + sid + "  分类名称 : " + title;
	}
}