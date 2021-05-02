class NagativeBalanceException extends Exception{
	public NagativeBalanceException(String msg) {
		super(msg);
	}
}

class BankAccount {
	private int balance;
	
	public void deposit(int amount) {
		balance += amount;
		
		System.out.println("예금: "+amount+"원 입금되었습니다.");
	}
	
	public void withdraw(int amount) throws NagativeBalanceException {
		if (amount  > balance) {
			throw new NagativeBalanceException("출금: " + amount+"원 잔액이 부족합니다.");
		}
		
		balance -= amount;
		System.out.println("출금: "+amount+"원 출금되었습니다.");
	
	}
}

public class EX4_4 {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.deposit(20000);
		try {
			bankAccount.withdraw(15000);
			bankAccount.withdraw(10000);
		} catch (NagativeBalanceException e) {
			System.out.println(e.getMessage());
		}

	}

}
