import java.util.Scanner;

public class Ex2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money, cost;
		Scanner input = new Scanner(System.in);

		System.out.println("πﬁ¿∫µ∑: ");
		money = input.nextInt();
		
		System.out.println("ªÛ«∞∞°∞›:");
		cost = input.nextInt();
		
		System.out.println("∫Œ∞°ºº: "+ cost / 10);
		System.out.println("¿‹µ∑: "+ (money - cost));
	}

}
