import java.util.Scanner;

public class Ex2_1 {
	public static void main(String[] args) {
		int oranges;
		int q, r;
		Scanner input = new Scanner(System.in);
		
		System.out.println("오렌지의 개수를 입력하시오: ");
		oranges = input.nextInt();

		q = oranges / 10;
		r = oranges % 10;
		
		System.out.println(q + "박스가 필요하고 "+ r+ "개가 남습니다.");
	}
}
