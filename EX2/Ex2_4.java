import java.util.Scanner;

public class Ex2_4 {

	public static void main(String[] args) {
		int userInteger;
		int q, r;
		int []binary = new int[20];
		int i = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Á¤¼ö: ");
		userInteger = input.nextInt();
		
		q = userInteger;
		i = 0;

		while(q > 1) {
			r = q % 2;
			q = q / 2;
			binary[i] = r;

			i++;
		}

		binary[i] = q;

		for (int j = i; j >= 0; j--) {
			System.out.print(binary[j]);
		}
	}

}
