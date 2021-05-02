class NagativeBalanceException extends Exception{
	public NagativeBalanceException(String msg) {
		super(msg);
	}
}

class BankAccount {
	private int balance;
	
	public void deposit(int amount) {
		balance += amount;
		
		System.out.println("����: "+amount+"�� �ԱݵǾ����ϴ�.");
	}
	
	public void withdraw(int amount) throws NagativeBalanceException {
		if (amount  > balance) {
			throw new NagativeBalanceException("���: " + amount+"�� �ܾ��� �����մϴ�.");
		}
		
		balance -= amount;
		System.out.println("���: "+amount+"�� ��ݵǾ����ϴ�.");
	
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
