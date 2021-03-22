import java.util.Scanner;

public class EX3_6 {

	// ���� �ʱ�ȭ�ϱ�
	public static void initBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	// ���� ����ϱ�
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("| "+ board[i][j] +" ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	// ���� �Ǵ��ϱ�
	// -1 : ���� ����
	// 0 : user �̱�
	// 1 : computer �̱�
	public static int checkBoard(char[][] board) {
		int win = -1;
		
		// row �˻�
		for (int i = 0; i < 3; i++) {
			// ���� �࿡�� ù��° ĭ�� �ι�° ĭ�� ���� �����̰�, �ι�° ĭ�� ����° ĭ�� ���� ������ ��
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
				// ĭ�� ������� �ʴٸ�
				if (board[i][0] != ' ') {
					// ĭ�� ���ڰ� x���, user�� �̰��.
					// �ƴ϶��, computer�� �̰��.
					if (board[i][0] == 'x') win = 0;
					else  win = 1;

					return win;
				}
			}
		}
		
		// column �˻�
		for (int i = 0; i < 3; i++) {
			// ���� ������ ù��° ĭ�� �ι�° ĭ�� ���� �����̰�, �ι�° ĭ�� ����° ĭ�� ���� ������ ��
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				if (board[0][i] != ' ') {
					if (board[0][i] == 'x') win = 0;
					else win = 1;

					return win;
				}
			}
		}

		// �밢�� �˻�
		if ((board[0][0] == board[1][1] && board[0][0] == board[2][2]) || 
				(board[0][2]==board[1][1] && board[0][2] == board[2][0])) {
			if (board[1][1] != ' ') {
				if (board[1][1] == 'x') win = 0;
				else win = 1;
				
				return win;
			}
		}

		return win;
	}
	
	// ��� ����ϱ�
	public static void printResult(int win){
		if (win == 0) System.out.println("����� �̰���ϴ�!");
		else if (win == 1) System.out.println("��ǻ�Ͱ� �̰���ϴ�!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][3];
		int x, y;
		int a, b;
		int win = -1;
		
		Scanner sc = new Scanner(System.in);
		
		// ���带 �ʱ�ȭ�Ѵ�.
		initBoard(board);

		do {
			// ���带 �͹̳ο� ����Ѵ�.
			printBoard(board);
			
			// ����ڷκ��� ��ǥ�� �Է¹޴´�.
			System.out.println("��ǥ�� �Է��ϼ���");
			x = sc.nextInt();
			y = sc.nextInt();
			
			// ����ִ� ĭ�� ��ǥ�� �Է¹��� ������ 
			// ����ڷκ��� ��ǥ�� �Է¹޴´�.
			while (board[x][y] != ' ') {
				System.out.println("�߸��� ��ǥ�Դϴ�. �ٽ� �Է��ϼ���");
				x = sc.nextInt();
				y = sc.nextInt();
			}
			// �Է¹��� ��ǥ�� ĭ�� x�� ���´�.
			board[x][y] = 'x';
			
			// ���ڰ� �ִ��� �˻��Ѵ�.
			win = checkBoard(board);
			// ���ڰ� �ִ� ���
			// ����� ����ϰ� ������ �����Ѵ�.
			if (win != -1) {
				printResult(win);
				break;
			}
			
			// ����ִ� ĭ�� ��ǥ�� ������ ������
			// �������� ��ǥ�� �����Ѵ�.
			do {
				a = (int)(Math.random() * 3);
				b = (int)(Math.random() * 3);
			} while(board[a][b] != ' ');
			// ������ ��ǥ�� ĭ�� o�� ���´�.
			board[a][b] = 'o';
			
			// ���ڰ� �ִ��� �˻��Ѵ�.
			win = checkBoard(board);
			// ���ڰ� �ִ� ���
			// ����� ����ϰ� ������ �����Ѵ�.
			if (win != -1) {
				printBoard(board);
				printResult(win);
				break;
			}
		} while (true);
	}
}
