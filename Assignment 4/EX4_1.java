import java.util.Scanner;

abstract class Sprite {
	int x = 3, y = 3;

	abstract void move(char c);
}

class Main extends Sprite{
	void move(char c) {
		switch(c) {
		case 'h': --y; break;
		case 'j': --x; break;
		case 'k': ++x; break;
		case 'l': ++y; break;
		}
	}
}

class Gold extends Sprite{
	
	public Gold() {
		x = 3;
		y = 6;
	}
	
	void move(char c) {
		
	}
}

class Monster extends Sprite {
	
	public Monster() {
		x = y = 7;
	}

	void move(char c) {
		x += (Math.random()-0.5)>0?1:-1;
		y += (Math.random()-0.5)>0?1:-1;
	}
}

class Board {
	private char[][] board = new char[10][19];
	
	public Board() {
		for (int i = 0; i < board.length; i++) {
			if (i == 0 || i == board.length-1) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = '#';
				}
			} else{
				for (int j = 0; j < board[i].length; j++) {
					if(j == 0 || j == board[i].length-1) {
						board[i][j] = '#';
					} else {
						board[i][j] = ' ';
					}
				}
			}
		}
	}
	
	public void print(Main user, Monster monster, Gold gold) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char c = ' ';
				if (i == user.x && j == user.y) c = '@';
				else if (i == monster.x && j == monster.y) c = 'M';
				else if (i == gold.x && j == gold.y) c = 'G';
				else c = board[i][j];
				
				System.out.print(c);
			}
			System.out.println();
		}
	}
}

public class EX4_1 {
	// -1 : 아무일도 없었음
	// 0 : Monster has got Gold
	// 1 : I have got Gold
	// 2 : Monster has got me
	public static int judge(Main user, Monster monster, Gold gold) {
		int result = -1;
	
		if (monster.x == gold.x && monster.y == gold.y) result = 0;
		else if (user.x == gold.x && user.y == gold.y) result = 1;
		else if (monster.x == user.x && monster.y == user.y) result = 2;
		else result = -1;
	
		return result;
	}
	
	public static void printResult(int result) {
		String msg;
		
		switch(result) {
		case 0: msg = "Monster has got Gold"; break;
		case 1: msg = "I have got Gold"; break;
		case 2: msg = "Monster has got me"; break;
		default: msg = ""; break;
		}
		
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char input;
		int result;

		Board board = new Board();
		Main user = new Main();
		Monster monster = new Monster();
		Gold gold = new Gold();

		do {
			board.print(user, monster, gold);
			System.out.print("왼쪽(h), 위쪽(j), 아래쪽(k), 오른쪽(l): ");
			
			input = sc.next().charAt(0);
			user.move(input);
			result = judge(user, monster, gold);
			if (result != -1) {
				printResult(result);
				break;
			}
			
			monster.move(' ');
			result = judge(user, monster, gold);
			if (result != -1) {
				printResult(result);
				break;
			}
		} while(true);
		board.print(user, monster, gold);
	}

}

