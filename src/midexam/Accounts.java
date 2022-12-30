package midexam;

public class Accounts extends Customer{
	static int account_num = 0;
	private int acc_no;
	private double balance;
	
	//getter setter for account fields
	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//get customer's full name
	public String getCustomerName() {
		return this.getFirst_name() + " " + this.getLasT_name();
	}

	//constructor 
	public Accounts(String first_name, String last_name, String location, String username, String password, double balance) {
		super(first_name, last_name, location, username, password);
		account_num = account_num + 1;
		this.acc_no = account_num;
		this.balance = balance;
	}
	
	public Accounts() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Boolean withdraw(double amount) {
		
		this.balance = this.balance - amount;
		return true;
		
	}
	
	public Boolean deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		return true;
	}

}
