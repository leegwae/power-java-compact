import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Dice {
	int x, y;
	int num;
	Color c;
	
	public Dice(int x, int y, Color c, int num) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.num = num;
	}
}

class DicePanel extends JPanel {
	Dice[] dices = new Dice[2];
	
	public DicePanel() {
		dices[0] = new Dice(200, 100, Color.blue, getRandomNum());
		dices[1] = new Dice(500, 100, Color.red, getRandomNum());
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				for (int i = 0; i < 2; i++) {
					dices[i].num = getRandomNum();
				}
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 2; i++) {
			g.setColor(Color.black);
			g.drawRect(dices[i].x, dices[i].y, 60, 60);
			g.setColor(dices[i].c);
			
			drawDots(g, dices[i].x, dices[i].y, dices[i].num);	
		}
	}
	
	private boolean[][] getFilledDots(int n) {
		boolean[][] isFilled = new boolean[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				isFilled[i][j] = false;
			}
		}
		
		switch (n) {
		case 1:
			isFilled[1][1] = true;
			break;
		case 2:
			isFilled[0][0]= true;
			isFilled[2][2] = true;
			break;
		case 3:
			isFilled[0][0] = true;
			isFilled[1][1] = true;
			isFilled[2][2] = true;
			break;
		case 4:
			isFilled[0][0] = true;
			isFilled[0][2] = true;
			isFilled[2][0] = true;
			isFilled[2][2] = true;
			break;
		case 5:
			isFilled[0][0] = true;
			isFilled[0][2] = true;
			isFilled[1][1] = true;
			isFilled[2][0] = true;
			isFilled[2][2] = true;
			break;
		case 6:
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (j != 1) {
						isFilled[i][j] = true;
					}
				}
			}
			break;
		}
		
		return isFilled;
	}
	
	private void drawDots(Graphics g, int x, int y, int n) {
		boolean[][] isFilled = getFilledDots(n);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (isFilled[i][j])
					g.fillRect(x + 10 + j * 15, y + 10 + i * 15, 10, 10);
			}
		}
	}
	
	private int getRandomNum() {
		return (int)(Math.random() * 6) + 1;
	}
}
public class EX6_1 extends JFrame{

	public EX6_1() {
		setTitle("DiceGame");
		setSize(800, 300);
		
		add(new DicePanel());
		
		setVisible(true);
	}
	public static void main(String[] args) {
		EX6_1 f = new EX6_1();

	}

}
