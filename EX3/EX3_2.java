
public class EX3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j = 0;
		
		// 소수 : 1과 자기자신으로 나누었을 때만 나머지가 0이다.
		System.out.print("2부터 100사이의 소수: ");
		for (i = 2; i <= 100; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) System.out.print(j + " ");
		}
	}

}
