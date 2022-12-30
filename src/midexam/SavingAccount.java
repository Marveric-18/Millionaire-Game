package midexam;

public class SavingAccount extends Accounts{
	
	private static String acc_type = "Saving";
	private static String overdraft = "N/A";

	public SavingAccount(String first_name, String last_name, String location, String username, String password, double balance) {
		super(first_name, last_name, location, username, password, balance);
	}

	public static String getAcc_type() {
		return acc_type;
	}
	
	public Boolean withdraw(double amount) {
		double balance = this.getBalance();
		if(balance - amount < 0)
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
