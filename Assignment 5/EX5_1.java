import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame implements ActionListener {
	JButton[][] buttons;
	char turn = 'O';

	public TicTacToe() {
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("틱택토 게임!");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
		buttons = new JButton[3][3];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 200));
				buttons[i][j].addActionListener(this);
				buttonPanel.add(buttons[i][j]);
			}
		}

		add(buttonPanel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int result;
		char[][] texts = new char[3][3];
		Object obj = e.getSource();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (obj == buttons[i][j] && buttons[i][j].getText().equals(" ") == true) {
					if (turn == 'X') {
						buttons[i][j].setText("X");
						turn = 'O';
					} else {
						buttons[i][j].setText("O");
						turn = 'X';
					}
					
					for (int x = 0; x < 3;x++) {
						for (int y = 0; y < 3; y++) {
							texts[x][y]= buttons[x][y].getText().charAt(0);
							System.out.print(texts[x][y]+",");
						}
						System.out.println();
					}
					result = judge(texts);
					
					if (result != -1) {
						JPanel resultPanel = new JPanel();
						String winner ="";
						
						if (result == 0) winner = "O";
						else if (result == 1) winner = "X";
						
						System.out.println(winner+"님이 승리하셨습니다.");
						resultPanel.add(new JTextField(winner+"님이 승리하셨습니다."));
						
						this.add(resultPanel, BorderLayout.SOUTH);
					}
				}
			}
		}
	}

	// 승자 판단하기
	// -1 : 승자 없음
	// 0 : O 이김
	// 1 : X 이김
	public static int judge(char[][] board) {
		int win = -1;

		// row 검사
		for (int i = 0; i < 3; i++) {
			// 같은 행에서 첫번째 칸과 두번째 칸이 같은 문자이고, 두번째 칸과 세번째 칸이 같은 문자일 때
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
				// 칸이 비어있지 않다면
				if (board[i][0] != ' ') {
					// 칸의 문자가 x라면, x가 이겼다.
					// 아니라면, o가 이겼다.
					if (board[i][0] == 'X') win = 1;
					else win = 0;

					return win;
				}
			}
		}

		// column 검사
		for (int i = 0; i < 3; i++) {
			// 같은 열에서 첫번째 칸과 두번째 칸이 같은 문자이고, 두번째 칸과 세번째 칸이 같은 문자일 때
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				if (board[0][i] != ' ') {
					if (board[0][i] == 'X') win = 1;
					else win = 0;

					return win;
				}
			}
		}

		// 대각선 검사
		if ((board[0][0] == board[1][1] && board[0][0] == board[2][2])
				|| (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
			if (board[1][1] != ' ') {
				if (board[1][1] == 'X') win = 1;
				else win = 0;

				return win;
			}
		}

		return win;
	}

	public static void main(String[] args) {
		TicTacToe f = new TicTacToe();
	}

}
