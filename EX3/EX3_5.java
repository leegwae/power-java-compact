import java.util.Scanner;

public class EX3_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int termCount;
		int lastTerm1, lastTerm2;
		int currentTerm;
		
		System.out.println("출력할 항의 개수: ");
		termCount = sc.nextInt();
		
		lastTerm1 = 0;		// fib(0) = 0
		lastTerm2 = 1;		// fib(1) = 1
		for (int i = 0; i < termCount; i++) {
			if (i < 2) System.out.print(i + " ");
			else {
				currentTerm = lastTerm1 + lastTerm2;
				System.out.print(currentTerm + " ");

				lastTerm1 = lastTerm2;
				lastTerm2 = currentTerm;
			}
		}
	}

}
