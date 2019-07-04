package H9.list38;
/*综合实战:数据表与简单Java类映射转换*/
/*
 * 数据实体表设计 = 类的定义
 * 表中的字段 = 类的成员属性
 * 表的外键关联 = 引用关联
 * 表的一行记录 = 类的一个实例化对象
 * 表的多行记录 = 对象数组(类的多个实例化对象)
 * 
 * */
public class list_38_1 {

	/*
	 * 
	 * 部门表dept
	 * 部门编号   number(2) 	(pk)
	 * 部门名称 varchar2(50)
	 * 部门位置 varchar2(50)
	 * 
	 * 
	 * 雇员表emp
	 * 雇员编号 number(4) 	(pk)
	 * 部门编号 number(2) 	(fk)
	 * 姓名  varchar2(20)
	 * 职位 varchar2(10)
	 * 基本工资  number(7,2)
	 * 佣金 number(7,2)
	 * 领导编号 number(4)
	 * 
	 * 
	 * 
	 * 关系
	 * 一个部门有多个雇员
	 * 一个雇员属于一个部门
	 * 一个雇员有一个领导
	 * 
	 * 
	 * 
	 * 将定义为简单Java类,获取以下信息
	 * 	根据部门信息获得一下内容
	 * 		一个部门的完整信息
	 * 		一个部门之中所以雇员的完整信息
	 * 根据雇员信息获得一下内容
	 * 		一个雇员所在的部门信息
	 * 		一个雇员对应的领导的信息
	 * 
	 * */
	public static void main(String[] args) {
		// 第一步:根据关系进行类的定义
		//定义出各个的实例化对象,此时没有任何的关联定义
		Dept dept = new Dept(10	, "财务部", "上海");
		Emp empA = new Emp(7369L, "张三", "出纳", 800.00, 0.00);
		Emp empB = new Emp(7368L, "李四", "应收", 1700.00, 100.00);
		Emp empC = new Emp(7367L, "王五", "应付", 2600.00, 200.00);
		//需要为对象进行关联的设置		
		empA.setDept(dept);//设置雇员与部门的关联
		empB.setDept(dept);//设置雇员与部门的关联
		empC.setDept(dept);//设置雇员与部门的关联
		empA.setMgr(empB);//设置雇员与领导的关联
		empB.setMgr(empC);//设置雇员与领导的关联
		dept.setEmps(new Emp[] {empA,empB,empC});//部门与雇员
		//第二步:根据关联获取数据
		System.out.println(dept.getinfo());//部门信息
		for (int i = 0; i < dept.getEmps().length; i++) {
			System.out.println("\t"+dept.getEmps()[i].getinfo());
			if (dept.getEmps()[i].getMgr() != null )
			System.out.println("\t\t " + dept.getEmps()[i].getMgr().getinfo());
		}
		System.out.println("-----------------------------");
		System.out.println(empB.getDept().getinfo());//根据雇员获取部门信息
		System.out.println(empB.getMgr().getinfo());//根据雇员获取领导信息
		
		
	}

}
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	private Emp  emps[];//多个雇员信息
	
	public Emp[] getEmps() {
		return emps;
	}
	public void setEmps(Emp[] emps) {
		this.emps = emps;
	}
	public Dept(long deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public String getinfo() {
		return "部门信息 \n部门编号 : " + this.deptno+
				" 部门名称 : " + this.dname+
				" 位置 : "+ this.loc;
	}
	
	
}
class Emp{
	private long  empno; 
	private String ename;
	private String ejob;
	private double sal;
	private double comm;
	private Dept dept; //所属部门
	private Emp mgr;//所属领导
	public Dept getDept() {
		return this.dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public Emp getMgr() {
		return this.mgr;
	}
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}
	public Emp(long empno, String ename, String ejob, double sal, double comm) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.ejob = ejob;
		this.sal = sal;
		this.comm = comm;
	} 
	public String getinfo() {
		return "雇员信息 [雇员编号=" + this.empno + 
				", 雇员姓名=" + this.ename + 
				", 职务=" + this.ejob + 
				", 基本工资=" + this.sal + 
				", 佣金=" + this.comm + "]";
	} 
	
	
}
