package list_41;
/*综合实战: 复杂 多对多映射*/
/*
 * 权限
 * 权限ID  (pk)
 * 角色ID  (fk)
 * 名称
 * 
 * 角色
 * 角色ID  (pk)
 * 名称
 * 
 * 用户
 * 用户ID   (pk)
 * 姓名
 * 
 * 用户-角色
 * 用户ID	(fk)
 * 角色ID	(fk)
 * 
 * 一个用户可以拥有多个角色,一个角色可能拥有多个用户
 * 一个角色可以拥有多个权限
 * 
 * 要求实现如下查询功能
 * 		可以根据一个用户找到该用户的所有角色,以及每一个角色对应的所有权限
 * 		可以根据一个角色找到该角色下的所有权限,以及拥有此角色的全部用户信息
 * 		可以根据一个权限找到具备此权限的所有用户信息

 * */
public class list_41_1 {
	public static void main(String[] args) {
		// 第一步 根据结构设置对象
		Member memberA = new Member(1001, "张三");
		Member memberB = new Member(1002, "李四"); 
		Role roleA = new Role(1, "系统配置");
		Role roleB = new Role(2, "备份管理");
		Role roleC = new Role(3, "人事管理");
		Privlege priA = new Privlege(1000L, "系统初始化");
		Privlege priB = new Privlege(1001L, "系统还原");
		Privlege priC = new Privlege(1002L, "系统环境修改")
				;
		Privlege priD = new Privlege(2000L, "备份员工数据");
		Privlege priE = new Privlege(2001L, "备份部门数据");
		Privlege priF = new Privlege(2002L, "备份公文数据");
		
		Privlege priG = new Privlege(3000L, "增加员工");
		Privlege priH = new Privlege(3001L, "编辑员工");
		Privlege priI = new Privlege(3002L, "浏览员工");
		Privlege priJ = new Privlege(3003L, "删除员工");
		//增加角色与权限的关系
		roleA.setPrivleges(new Privlege[] {priA,priB,priC });
		roleB.setPrivleges(new Privlege[] {priD,priE,priF });
		roleC.setPrivleges(new Privlege[] {priG,priH,priI,priJ });
		//增加权限与角色的对应
		priA.setRole(new Role[] { roleA});
		priB.setRole( new Role[] { roleA});
		priC.setRole( new Role[] { roleA});		
		priD.setRole( new Role[] { roleB});
		priE.setRole( new Role[] { roleB});
		priF.setRole( new Role[] { roleB});		
		priG.setRole( new Role[] { roleC});
		priH.setRole( new Role[] { roleC});
		priI.setRole( new Role[] { roleC});
		priJ.setRole( new Role[] { roleC});		
		//增加用户与角色的关系
		memberA.setRole(new Role[] {roleA,roleB});
		memberB.setRole(new Role[] {roleB,roleA ,roleC});
		//增加角色与用户的关系
		roleA.setMembers(new Member[] {memberA,memberB});
		roleB.setMembers(new Member[] {memberA,memberB});
		roleC.setMembers(new Member[] { memberB});		
		// 第二补  根据要求获取数据
		System.out.println("------------------通过用户查找信息------------------");
		System.out.println(memberB.getinfo());
		for (int i = 0; i < memberB.getRoles().length; i++) {
			System.out.println("\t"+memberB.getRoles()[i].getinfo());			
			for (int j = 0; j < memberB.getRoles()[i].getPrivleges().length; j++) {
				System.out.println("\t\t" +memberB.getRoles()[i].getPrivleges()[j].getinfo() );
			}
		}
		
		System.out.println("------------------通过角色查找信息------------------");
		System.out.println(roleB.getinfo());
		System.out.println("\t浏览此角色下的所有权限信息");
		for (int i = 0; i < roleB.getPrivleges().length; i++) {
			System.out.println("\t\t"+roleB.getPrivleges()[i].getinfo());
		}
		System.out.println("\t浏览此角色下的所有用户信息");
		for (int i = 0; i < roleB.getMembers().length; i++) {
			System.out.println("\t\t"+roleB.getMembers()[i].getinfo());
		}
		
		System.out.println("------------------通过权限查找信息------------------");
		System.out.println(priA.getinfo());
		for (int i = 0; i < priA.getRoles().length ; i++) {			
			System.out.println("\t"+priA.getRoles()[i].getinfo());
		}
		//不懂
	}
}
//用户
class Member{
	private long mid;
	private String name;
	private Role roles[];
	public  void  setRole(Role roles[]) {
		this.roles = roles;
	}
	public Role[] getRoles() {
		return this.roles;
	}
	public Member(long mid,String name) {
		this.mid=mid;
		this.name=name;
	}
	public String getinfo() {
		return " 用户信息: 用户ID : " + mid + " 用户名称 : " + name;
	}
}
//角色
class Role{
	private long rid;
	private String name;
	private Member members[];	
	private Privlege privleges[];
	public Privlege[] getPrivleges() {
		return privleges;
	}
	public Member[] getMembers() {
		return members;
	}
	public void setPrivleges(Privlege[] privleges) {
		this.privleges = privleges;
	}
	public void setMembers(Member[] members) {
		this.members = members;
	}
	public Role(long rid,String name) {
		this.rid=rid;
		this.name=name;
	}
	public String getinfo() {
		return " 角色信息: 角色ID : " + rid + " 角色名称 : " + name;
	}
}
//权限
class Privlege{
	private long pid;
	private String name;
	private Role roles[];
	public  void  setRole(Role roles[]) {
		this.roles = roles;
	}
	public Role[] getRoles() {
		return this.roles;
	}
	public Privlege(long pid,String name) {
		this.pid=pid;
		this.name=name;
	}
	public String getinfo() {
		return " 权限信息:  权限ID : " + pid + " 权限名称 : " + name;
	}
}
