import java.util.Scanner;

public class Ex2_2 {

	public static void main(String[] args) {
		double m, k;
		Scanner input = new Scanner(System.in);
		
		System.out.println("마일을 입력하시오: ");
		m = input.nextDouble();
		
		k = m * 1.609;
		
		System.out.println(m + "마일은 "+k+"킬로미터입니다.");
	}

}
