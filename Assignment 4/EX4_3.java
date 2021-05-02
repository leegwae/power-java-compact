import java.util.Scanner;

public class EX4_3{
	
	public static boolean judge(String given, char[] answer) {		
		for (int i = 0; i < given.length(); i++) {
			if (given.charAt(i) != answer[i]) return false;
		}
		return true;
	}
	
	public static void edit(String given, char[] answer, char input) {
		int index = given.indexOf(input);
		
		if (index != -1) {
			answer[index] = given.charAt(index);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String given = "count";
		char[] answer = new char[given.length()];
		char input;
		
		for (int i = 0; i < answer.length; i++)
			answer[i] = '_';
		
		do {
			System.out.print("������ ����: ");
			for (int i = 0; i < answer.length; i++)
				System.out.print(answer[i]);
			System.out.println();
			
			System.out.print("���ڸ� �����Ͻÿ�: ");
			input = sc.next().charAt(0);
			
			edit(given, answer, input);
			if (judge(given, answer)) break;
		} while(true);
		
		System.out.print("����: ");
		for (char c : answer) System.out.print(c);
		
	}
}
