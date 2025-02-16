package session1;

public class BankAccount {
	
	private Integer balance;
	
	//Constructor
	public BankAccount(int initialBalance) {
		balance=initialBalance;
		
		
	}
	


	public Integer withdraw(Integer amount) {
		if(balance < amount) {
			throw new NotEnoughFundsException(amount, balance);
			
		}
		balance-=amount;
		return balance;
	}

}
