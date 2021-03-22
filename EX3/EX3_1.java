
public class EX3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {
			int k = 5 % (i+1);

			for (int j = 0; j < 5; j++) {
				if (j < k || (5-k) <= j) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println("\n");
		}
	}

}
