
public class EX3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k = 0;

		for (i = 1; i < 100; i++) {
			for (j = 1; j < 100;j++) {
				for (k = 1; k < 100; k++) {
					if (i * i + j * j == k * k) {
						System.out.println(i + " " + j + " " + k);

						break;
					}
				}
			}
		}
	}

}
