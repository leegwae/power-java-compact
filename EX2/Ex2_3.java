import java.util.Scanner;

public class Ex2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money, cost;
		Scanner input = new Scanner(System.in);

		System.out.println("������: ");
		money = input.nextInt();
		
		System.out.println("��ǰ����:");
		cost = input.nextInt();
		
		System.out.println("�ΰ���: "+ cost / 10);
		System.out.println("�ܵ�: "+ (money - cost));
	}

}
