import java.util.Scanner;

public class Ex2_1 {
	public static void main(String[] args) {
		int oranges;
		int q, r;
		Scanner input = new Scanner(System.in);
		
		System.out.println("�������� ������ �Է��Ͻÿ�: ");
		oranges = input.nextInt();

		q = oranges / 10;
		r = oranges % 10;
		
		System.out.println(q + "�ڽ��� �ʿ��ϰ� "+ r+ "���� �����ϴ�.");
	}
}
