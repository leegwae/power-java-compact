import java.util.Scanner;
public class EX5_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] seats = new int[10];
		int userInput;

		// 좌석 초기화
		for (int i = 0; i < seats.length; i++) {
			seats[i] = 0;
		}
		
		do {
			System.out.println("==========================");
			for (int i = 0; i < seats.length;i++) {
				System.out.print(i +" ");
			}
			System.out.println();
			System.out.println("==========================");
			for (int i = 0; i < seats.length;i++) {
				System.out.print(seats[i] +" ");
			}
			System.out.println();
			System.out.print("몇번째 좌석을 예약하시겠습니까? ");
			
			userInput = sc.nextInt();
			
			if (userInput == -1) {
				System.out.println("예약 시스템을 종료합니다.");
				break;
			}
			
			if (seats[userInput] == 0) {
				seats[userInput] = 1;
				System.out.println("예약되었습니다"); 
			} else {
				System.out.println("예약할 수 없습니다."); 
			}
			System.out.println();
			System.out.println();
			System.out.println();
		} while(true);
	}
}