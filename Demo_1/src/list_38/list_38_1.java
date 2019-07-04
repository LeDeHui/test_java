package list_38;
/*�ۺ�ʵս:���ݱ����Java��ӳ��ת��*/
/*
 * ����ʵ������ = ��Ķ���
 * ���е��ֶ� = ��ĳ�Ա����
 * ���������� = ���ù���
 * ���һ�м�¼ = ���һ��ʵ��������
 * ��Ķ��м�¼ = ��������(��Ķ��ʵ��������)
 * 
 * */
public class list_38_1 {

	/*
	 * 
	 * ���ű�dept
	 * ���ű��   number(2) 	(pk)
	 * �������� varchar2(50)
	 * ����λ�� varchar2(50)
	 * 
	 * 
	 * ��Ա��emp
	 * ��Ա��� number(4) 	(pk)
	 * ���ű�� number(2) 	(fk)
	 * ����  varchar2(20)
	 * ְλ varchar2(10)
	 * ��������  number(7,2)
	 * Ӷ�� number(7,2)
	 * �쵼��� number(4)
	 * 
	 * 
	 * 
	 * ��ϵ
	 * һ�������ж����Ա
	 * һ����Ա����һ������
	 * һ����Ա��һ���쵼
	 * 
	 * 
	 * 
	 * ������Ϊ��Java��,��ȡ������Ϣ
	 * 	���ݲ�����Ϣ���һ������
	 * 		һ�����ŵ�������Ϣ
	 * 		һ������֮�����Թ�Ա��������Ϣ
	 * ���ݹ�Ա��Ϣ���һ������
	 * 		һ����Ա���ڵĲ�����Ϣ
	 * 		һ����Ա��Ӧ���쵼����Ϣ
	 * 
	 * */
	public static void main(String[] args) {
		// ��һ��:���ݹ�ϵ������Ķ���
		//�����������ʵ��������,��ʱû���κεĹ�������
		Dept dept = new Dept(10	, "����", "�Ϻ�");
		Emp empA = new Emp(7369L, "����", "����", 800.00, 0.00);
		Emp empB = new Emp(7368L, "����", "Ӧ��", 1700.00, 100.00);
		Emp empC = new Emp(7367L, "����", "Ӧ��", 2600.00, 200.00);
		//��ҪΪ������й���������		
		empA.setDept(dept);//���ù�Ա�벿�ŵĹ���
		empB.setDept(dept);//���ù�Ա�벿�ŵĹ���
		empC.setDept(dept);//���ù�Ա�벿�ŵĹ���
		empA.setMgr(empB);//���ù�Ա���쵼�Ĺ���
		empB.setMgr(empC);//���ù�Ա���쵼�Ĺ���
		dept.setEmps(new Emp[] {empA,empB,empC});//�������Ա
		//�ڶ���:���ݹ�����ȡ����
		System.out.println(dept.getinfo());//������Ϣ
		for (int i = 0; i < dept.getEmps().length; i++) {
			System.out.println("\t"+dept.getEmps()[i].getinfo());
			if (dept.getEmps()[i].getMgr() != null )
			System.out.println("\t\t " + dept.getEmps()[i].getMgr().getinfo());
		}
		System.out.println("-----------------------------");
		System.out.println(empB.getDept().getinfo());//���ݹ�Ա��ȡ������Ϣ
		System.out.println(empB.getMgr().getinfo());//���ݹ�Ա��ȡ�쵼��Ϣ
		
		
	}

}
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	private Emp  emps[];//�����Ա��Ϣ
	
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
		return "������Ϣ \n���ű�� : " + this.deptno+
				" �������� : " + this.dname+
				" λ�� : "+ this.loc;
	}
	
	
}
class Emp{
	private long  empno; 
	private String ename;
	private String ejob;
	private double sal;
	private double comm;
	private Dept dept; //��������
	private Emp mgr;//�����쵼
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
		return "��Ա��Ϣ [��Ա���=" + this.empno + 
				", ��Ա����=" + this.ename + 
				", ְ��=" + this.ejob + 
				", ��������=" + this.sal + 
				", Ӷ��=" + this.comm + "]";
	} 
	
	
}
