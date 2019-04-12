package Day09_1;

/*
 * 编写一个类实现银行账户的概念,包含的属性有   账号  密码  存款余额 利率 最小余额 ,定义封装这些属性的方法,账号自动生成
 * 编写主类,使用银行账户类,输入输出3个储户的上述信息
 * 考虑:哪些属性可以设计为static属性
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
	private int id;// 账号
	private String passsword;// 密码
	private double balance;// 余额
	private static double tate = 0.05;// 利率
	private static double minBalance = 1;// 最小余额
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