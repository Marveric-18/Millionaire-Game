package midexam;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class BankApplication {

	public static void main(String[] args) {
		
		Accounts account = null;
		account = new SavingAccount("Bruce", "Wayne", "Brampton", "bWayne", "12345", 500.00);
		System.out.println(((CheckingAccount) account).getOverdraft());
		/*
		//Datbase Setup
		SavingAccount s_account = new SavingAccount("Bruce", "Wayne", "Brampton", "bWayne", "12345", 500.00);
		SavingAccount s_account1 = new SavingAccount("Thanos", "Badman", "North York", "tBadman", "56789", 1000.00);
		CheckingAccount c_account = new CheckingAccount("Wonder", "Woman", "Oakville", "wWoman", "39087", 500000.00, 1500.00);
		CheckingAccount c_account1 = new CheckingAccount("Bruce", "Wayne", "Brampton", "bWayne", "12345", 400000.00, 10000.00);
		
		// Fake Database
		ArrayList<Accounts> fake_database=new ArrayList<Accounts>();
		fake_database.add(s_account);
		fake_database.add(s_account1);
		fake_database.add(c_account);
		fake_database.add(c_account1);
		
		// Accounts table
		ArrayList<Object> AccountsTable=new ArrayList<Object>();
		AccountsTable.add(s_account);
		AccountsTable.add(s_account1);
		AccountsTable.add(c_account);
		AccountsTable.add(c_account1);
		
		//Customer table
		ArrayList<Customer> CustomerTable =new ArrayList<Customer>();
		CustomerTable.add((Customer)s_account);
		CustomerTable.add((Customer)s_account1);
		CustomerTable.add((Customer)c_account);
		CustomerTable.add((Customer)c_account1);
		
		for( int i = 0; i< CustomerTable.size(); i++) {
			System.out.println( ((Customer) CustomerTable.get(i)).toCustomerString());
		}
		System.out.println("");
		for( int i = 0; i< AccountsTable.size(); i++) {
			System.out.println(AccountsTable.get(i).toString());
		}
		//Datbase Setup Done
		System.out.println("");
		Scanner read = new Scanner(System.in);
		
		System.out.println("Welcome to Banking Application");
		int account = 0;
		Accounts a_logged = null;
		SavingAccount s_LOGGED = null;
		CheckingAccount c_LOGGED = null;
		Boolean logged_flag = false;
		char acc_type;
		String username;
		String password;
		//sign in logic
		while(!logged_flag) {
			System.out.print("Please Enter Username: ");
			username = read.next();
			System.out.print("Please Enter Password: ");
			password = read.next();
			for( account = 0; account< fake_database.size(); account++) {
				a_logged = fake_database.get(account);
				if(a_logged.getUsername().equals(username)) {
					logged_flag = a_logged.login( username, password);
					if(logged_flag) {
						break;
					}
				}
			}// end of for loop
			if(!logged_flag) {
				System.out.println("Please enter correct username and password");
			}else {
				//////////////Check for Saving/Checking Account/////////////
				//a_logged = fake_database.get(account);
				System.out.println("Welcome " + a_logged.getCustomerName());
				username = a_logged.getUsername();
				System.out.println("Account Type :");
				System.out.println("Enter ‘C’ or ‘c’ for Checkings Account");
				System.out.println("Enter ‘S’ or ‘s’ for Savings Account");
				acc_type = read.next().charAt(0);
				if(a_logged instanceof SavingAccount &&  "s".equals( String.valueOf(acc_type).toLowerCase()))
				{	s_LOGGED = (SavingAccount) a_logged;}
				else if (a_logged instanceof CheckingAccount &&  "c".equals( String.valueOf(acc_type).toLowerCase()))
				{	c_LOGGED = (CheckingAccount) a_logged;}
				else {
					for( account = 0; account< fake_database.size(); account++) {
						if(fake_database.get(account).getUsername().equals(username)) {
							a_logged = fake_database.get(account);
							if(fake_database.get(account) instanceof SavingAccount &&  "s".equals( String.valueOf(acc_type).toLowerCase()))
							{	
								s_LOGGED = (SavingAccount) fake_database.get(account);
								break;
							}
							else if (fake_database.get(account) instanceof CheckingAccount &&  "c".equals( String.valueOf(acc_type).toLowerCase()))
							{	
								c_LOGGED = (CheckingAccount) fake_database.get(account);
								break;
							}
								
						}
					}// end of for loop
				
					if(c_LOGGED == null && s_LOGGED ==null) {
						logged_flag = false;
						if("s".equals( String.valueOf(acc_type).toLowerCase()))
							System.out.println("Your Saving account with " + username + " does not exist");
						else
							System.out.println("Your Checking account with " + username + " does not exist");
						}
						
					}
			}
		}//end of while loop
		///////////////Logged In///////////////////
		char operation = "Y".charAt(0);
		double operationAmount = 0;
		Boolean withdrawalFlag = false;
		while(true) {
			try {
				if( s_LOGGED != null) {
					a_logged = (Accounts) s_LOGGED;
					System.out.println(String.format("%-20s", "Name: "+ s_LOGGED.getCustomerName()));
					System.out.println("Account Type: " + s_LOGGED.getAcc_type());
					System.out.println("Account Balance: " + s_LOGGED.getBalance());
					
					
				}else {
					a_logged = (Accounts) c_LOGGED;
					System.out.println(String.format("%-20s", "Name: "+ c_LOGGED.getCustomerName()));
					System.out.println("Account Type: " + c_LOGGED.getAcc_type());
					System.out.println("Account Balance: " + c_LOGGED.getBalance());
				}
				System.out.println("\nOperations: ");
				System.out.println("Enter D or ‘d’ to deposit");
				System.out.println("Enter W or ‘w’ to withdraw");
				System.out.println("Enter x or ‘X’ to exit app");
				operation = read.next().charAt(0);
				
				if((String.valueOf(operation).toLowerCase()).equals("x"))
					throw new Exception("Exit");
				
				if((String.valueOf(operation).toLowerCase()).equals("d")) {
					try {
						System.out.print("Enter deposit amount: ");
						operationAmount = read.nextDouble();
						if(operationAmount<=0)
							throw new Exception("Enter valid amount");
						if ( a_logged.deposit(operationAmount)) {
							System.out.println("Amount deposited successfully");
							System.out.println("Your current balance: " + a_logged.getBalance());
						}else {
							System.out.println("Amount is not deposited! Server error");
						}
					}catch(Exception e) {
						System.out.println("Please enter valid amount to deposit");
					}
				}else if((String.valueOf(operation).toLowerCase()).equals("w")) {
					try {
						System.out.print("Enter withdrawal amount: ");
						operationAmount = read.nextDouble();
						if(operationAmount<=0)
							throw new Exception("Enter valid amount");
						if( s_LOGGED != null) 
							withdrawalFlag = s_LOGGED.withdraw(operationAmount);
						else
							withdrawalFlag = c_LOGGED.withdraw(operationAmount);
						if ( withdrawalFlag) {
							System.out.println("Amount withdrawed successfully");
							System.out.println("Your current balance: " + a_logged.getBalance());
						}else {
							if( s_LOGGED != null) 
								System.out.println("The amount you are trying to withdraw exceeds your current balance");
							else
								System.out.println("The amount you are trying to withdraw exceeds your overdraft limit");
						}
						
					}catch(Exception e) {
						System.out.println("Please enter valid amount to deposit");
					}
					
				}
				
				
			}catch(Exception e) {
				System.out.println("Goodbye "+ a_logged.getCustomerName());
				break;
			}
		}//end of while loop
		read.close();*/
	}//end main method

}// end Banking Application
