import java.util.Scanner;

public class EX3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operator;
		double op1, op2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연산을 입력하세요: ");
		operator = sc.next().charAt(0);
				
		System.out.println("숫자 2개를 입력하세요: ");
		op1 = sc.nextDouble();
		op2 = sc.nextDouble();
		
		switch(operator) {
		case '+': System.out.println(op1 + "+"+ op2+"=" +(op1+op2)); break;
		case '-' : System.out.println(op1 + "-"+ op2+"=" +(op1-op2)); break;
		case '*' : System.out.println(op1 + "*"+ op2+"=" +(op1*op2)); break;
		case '/' : 
			if (op2 == 0) System.out.println("잘못된 분모를 입력했습니다.");
			else System.out.println(op1 + "/"+ op2+"-" +(op1-op2));
			break;
		default: System.out.println("잘못된 연산자를 입력했습니다.");
		}
	
		sc.close();
	}
}
