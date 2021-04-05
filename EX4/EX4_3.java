class Account{
	String name;
	int balance;
	
	public Account(String name) {
		this.name = name;
		this.balance = 0;
		
		System.out.println("새로운 "+ name+" 계좌가 생성되었습니다.");
	}
	public void withdraw(int amount) {
		if (balance < amount) {
			System.out.println("통장에 잔고가 부족합니다.");
		} else {
			balance -= amount;
			
			System.out.println(amount+"원 인출");
		}
	}
	public void deposit(int amount) {
		balance += amount;
		
		System.out.println(amount+"원 저축");
	}
	public void transfer(int amount, Account account) {
		if (balance < amount) {
			System.out.println("통장에 잔고가 부족합니다.");
		} else {
			balance -= amount;
			account.balance += amount;
			
			System.out.println(name+"가 "+account.name+"에게 "+amount+"원 이체함");
		}
	}
	public void print() {
		System.out.println("고객 "+name+" 계좌잔고="+balance+"원");
	}
}
public class EX4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account("철수");	
		a1.deposit(50000);
		
		Account a2 = new Account("영희");
		a2.deposit(100000);
		
		a1.print();
		a2.print();
		
		a2.transfer(50000, a1);
		
		a1.print();
		a2.print();
	}

}
