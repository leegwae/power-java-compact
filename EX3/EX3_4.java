import java.util.Scanner;

public class EX3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operator;
		double op1, op2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���: ");
		operator = sc.next().charAt(0);
				
		System.out.println("���� 2���� �Է��ϼ���: ");
		op1 = sc.nextDouble();
		op2 = sc.nextDouble();
		
		switch(operator) {
		case '+': System.out.println(op1 + "+"+ op2+"=" +(op1+op2)); break;
		case '-' : System.out.println(op1 + "-"+ op2+"=" +(op1-op2)); break;
		case '*' : System.out.println(op1 + "*"+ op2+"=" +(op1*op2)); break;
		case '/' : 
			if (op2 == 0) System.out.println("�߸��� �и� �Է��߽��ϴ�.");
			else System.out.println(op1 + "/"+ op2+"-" +(op1-op2));
			break;
		default: System.out.println("�߸��� �����ڸ� �Է��߽��ϴ�.");
		}
	
		sc.close();
	}
}
