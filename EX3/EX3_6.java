import java.util.Scanner;

public class EX3_6 {

	// 보드 초기화하기
	public static void initBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	// 보드 출력하기
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
	
	// 승자 판단하기
	// -1 : 승자 없음
	// 0 : user 이김
	// 1 : computer 이김
	public static int checkBoard(char[][] board) {
		int win = -1;
		
		// row 검사
		for (int i = 0; i < 3; i++) {
			// 같은 행에서 첫번째 칸과 두번째 칸이 같은 문자이고, 두번째 칸과 세번째 칸이 같은 문자일 때
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
				// 칸이 비어있지 않다면
				if (board[i][0] != ' ') {
					// 칸의 문자가 x라면, user가 이겼다.
					// 아니라면, computer가 이겼다.
					if (board[i][0] == 'x') win = 0;
					else  win = 1;

					return win;
				}
			}
		}
		
		// column 검사
		for (int i = 0; i < 3; i++) {
			// 같은 열에서 첫번째 칸과 두번째 칸이 같은 문자이고, 두번째 칸과 세번째 칸이 같은 문자일 때
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				if (board[0][i] != ' ') {
					if (board[0][i] == 'x') win = 0;
					else win = 1;

					return win;
				}
			}
		}

		// 대각선 검사
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
	
	// 결과 출력하기
	public static void printResult(int win){
		if (win == 0) System.out.println("당신이 이겼습니다!");
		else if (win == 1) System.out.println("컴퓨터가 이겼습니다!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][3];
		int x, y;
		int a, b;
		int win = -1;
		
		Scanner sc = new Scanner(System.in);
		
		// 보드를 초기화한다.
		initBoard(board);

		do {
			// 보드를 터미널에 출력한다.
			printBoard(board);
			
			// 사용자로부터 좌표를 입력받는다.
			System.out.println("좌표를 입력하세요");
			x = sc.nextInt();
			y = sc.nextInt();
			
			// 비어있는 칸의 좌표를 입력받을 때까지 
			// 사용자로부터 좌표를 입력받는다.
			while (board[x][y] != ' ') {
				System.out.println("잘못된 좌표입니다. 다시 입력하세요");
				x = sc.nextInt();
				y = sc.nextInt();
			}
			// 입력받은 좌표의 칸에 x를 적는다.
			board[x][y] = 'x';
			
			// 승자가 있는지 검사한다.
			win = checkBoard(board);
			// 승자가 있는 경우
			// 결과를 출력하고 게임을 종료한다.
			if (win != -1) {
				printResult(win);
				break;
			}
			
			// 비어있는 칸의 좌표를 생성할 때까지
			// 랜덤으로 좌표를 생성한다.
			do {
				a = (int)(Math.random() * 3);
				b = (int)(Math.random() * 3);
			} while(board[a][b] != ' ');
			// 생성한 좌표의 칸에 o를 적는다.
			board[a][b] = 'o';
			
			// 승자가 있는지 검사한다.
			win = checkBoard(board);
			// 승자가 있는 경우
			// 결과를 출력하고 게임을 종료한다.
			if (win != -1) {
				printBoard(board);
				printResult(win);
				break;
			}
		} while (true);
	}
}
