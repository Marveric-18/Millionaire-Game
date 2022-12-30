package midexam;

public class CheckingAccount extends Accounts{

	private static String acc_type = "Chekings";
	private double overdraft;

	public CheckingAccount(String first_name, String last_name, String location, String username, String password, double balance, double overdraft) {
		super(first_name, last_name, location, username, password, balance);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public static String getAcc_type() {
		return acc_type;
	}
	
	public Boolean withdraw(double amount) {
		double balance = this.getBalance();
		if(balance - amount < -(this.getOverdraft()))
			return false;
		else
			return super.withdraw(amount);
	}
	
	@Override
	public String toString() {
		return "Accounts [acc_no =" + this.getAcc_no() + ", customer_name=" + this.getCustomerName() + ", balance=" + this.getBalance() + ", typr="
				+ this.getAcc_type() +  ", overdraft=" + this.overdraft + "]";
	}

}
