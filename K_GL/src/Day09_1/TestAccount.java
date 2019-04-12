package Day09_1;

/*
 * ��дһ����ʵ�������˻��ĸ���,������������   �˺�  ����  ������ ���� ��С��� ,�����װ��Щ���Եķ���,�˺��Զ�����
 * ��д����,ʹ�������˻���,�������3��������������Ϣ
 * ����:��Щ���Կ������Ϊstatic����
 * 
 */
public class TestAccount {
	public static void main(String[] args) {
		Account a1 = new Account("pass", 100);
		Account a2 = new Account("pass", 100);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
	}

}

class Account {
	private int id;// �˺�
	private String passsword;// ����
	private double balance;// ���
	private static double tate = 0.05;// ����
	private static double minBalance = 1;// ��С���
	private static int init = 1000;

	public Account(String passsword, double balance) {
		super();

		this.id = ++init;
		this.passsword = passsword;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getTate() {
		return tate;
	}

	public static void setTate(double tate) {
		Account.tate = tate;
	}

	public static double getMinBalance() {
		return minBalance;
	}

	public static void setMinBalance(double minBalance) {
		Account.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", passsword=" + passsword + ", balance=" + balance + "]";
	}

}