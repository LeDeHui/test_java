package list_41;
/*�ۺ�ʵս: ���� ��Զ�ӳ��*/
/*
 * Ȩ��
 * Ȩ��ID  (pk)
 * ��ɫID  (fk)
 * ����
 * 
 * ��ɫ
 * ��ɫID  (pk)
 * ����
 * 
 * �û�
 * �û�ID   (pk)
 * ����
 * 
 * �û�-��ɫ
 * �û�ID	(fk)
 * ��ɫID	(fk)
 * 
 * һ���û�����ӵ�ж����ɫ,һ����ɫ����ӵ�ж���û�
 * һ����ɫ����ӵ�ж��Ȩ��
 * 
 * Ҫ��ʵ�����²�ѯ����
 * 		���Ը���һ���û��ҵ����û������н�ɫ,�Լ�ÿһ����ɫ��Ӧ������Ȩ��
 * 		���Ը���һ����ɫ�ҵ��ý�ɫ�µ�����Ȩ��,�Լ�ӵ�д˽�ɫ��ȫ���û���Ϣ
 * 		���Ը���һ��Ȩ���ҵ��߱���Ȩ�޵������û���Ϣ

 * */
public class list_41_1 {
	public static void main(String[] args) {
		// ��һ�� ���ݽṹ���ö���
		Member memberA = new Member(1001, "����");
		Member memberB = new Member(1002, "����"); 
		Role roleA = new Role(1, "ϵͳ����");
		Role roleB = new Role(2, "���ݹ���");
		Role roleC = new Role(3, "���¹���");
		Privlege priA = new Privlege(1000L, "ϵͳ��ʼ��");
		Privlege priB = new Privlege(1001L, "ϵͳ��ԭ");
		Privlege priC = new Privlege(1002L, "ϵͳ�����޸�")
				;
		Privlege priD = new Privlege(2000L, "����Ա������");
		Privlege priE = new Privlege(2001L, "���ݲ�������");
		Privlege priF = new Privlege(2002L, "���ݹ�������");
		
		Privlege priG = new Privlege(3000L, "����Ա��");
		Privlege priH = new Privlege(3001L, "�༭Ա��");
		Privlege priI = new Privlege(3002L, "���Ա��");
		Privlege priJ = new Privlege(3003L, "ɾ��Ա��");
		//���ӽ�ɫ��Ȩ�޵Ĺ�ϵ
		roleA.setPrivleges(new Privlege[] {priA,priB,priC });
		roleB.setPrivleges(new Privlege[] {priD,priE,priF });
		roleC.setPrivleges(new Privlege[] {priG,priH,priI,priJ });
		//����Ȩ�����ɫ�Ķ�Ӧ
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
		//�����û����ɫ�Ĺ�ϵ
		memberA.setRole(new Role[] {roleA,roleB});
		memberB.setRole(new Role[] {roleB,roleA ,roleC});
		//���ӽ�ɫ���û��Ĺ�ϵ
		roleA.setMembers(new Member[] {memberA,memberB});
		roleB.setMembers(new Member[] {memberA,memberB});
		roleC.setMembers(new Member[] { memberB});		
		// �ڶ���  ����Ҫ���ȡ����
		System.out.println("------------------ͨ���û�������Ϣ------------------");
		System.out.println(memberB.getinfo());
		for (int i = 0; i < memberB.getRoles().length; i++) {
			System.out.println("\t"+memberB.getRoles()[i].getinfo());			
			for (int j = 0; j < memberB.getRoles()[i].getPrivleges().length; j++) {
				System.out.println("\t\t" +memberB.getRoles()[i].getPrivleges()[j].getinfo() );
			}
		}
		
		System.out.println("------------------ͨ����ɫ������Ϣ------------------");
		System.out.println(roleB.getinfo());
		System.out.println("\t����˽�ɫ�µ�����Ȩ����Ϣ");
		for (int i = 0; i < roleB.getPrivleges().length; i++) {
			System.out.println("\t\t"+roleB.getPrivleges()[i].getinfo());
		}
		System.out.println("\t����˽�ɫ�µ������û���Ϣ");
		for (int i = 0; i < roleB.getMembers().length; i++) {
			System.out.println("\t\t"+roleB.getMembers()[i].getinfo());
		}
		
		System.out.println("------------------ͨ��Ȩ�޲�����Ϣ------------------");
		System.out.println(priA.getinfo());
		for (int i = 0; i < priA.getRoles().length ; i++) {			
			System.out.println("\t"+priA.getRoles()[i].getinfo());
		}
		//����
	}
}
//�û�
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
		return " �û���Ϣ: �û�ID : " + mid + " �û����� : " + name;
	}
}
//��ɫ
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
		return " ��ɫ��Ϣ: ��ɫID : " + rid + " ��ɫ���� : " + name;
	}
}
//Ȩ��
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
		return " Ȩ����Ϣ:  Ȩ��ID : " + pid + " Ȩ������ : " + name;
	}
}
