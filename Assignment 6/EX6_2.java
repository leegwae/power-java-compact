import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Car {
	Color c1, c2;
	int size;
	int x, y;
	
	public Car(
			int x, int y, int size,
			Color c1, Color c2) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.c1 = c1;
		this.c2 = c2;
	}
}

public class EX6_2 extends JFrame implements ActionListener {
	// =========== [윈도우 가로, 세로] ==========================
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 500;
	
	// ============= [ 자동차 ]==================================
	Car[] cars = new Car[3];
	// ============= [ 자동차 사각형/원 가로, 세로 ] =================
	int rw1 = 100;
	int rh1 = 30;
	int rw2 = 150;
	int rh2 = 40;
	int c = 40;

	
	// ================= [ 타이머 관련 ]======================== 
	int xSpeed = 3;
	int period = 10;
	
	class CarPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (int i = 0; i < 3; i++) {
				g.setColor(cars[i].c1);
				g.fillRect(cars[i].x + 20, cars[i].y, rw1, rh1);
				
				g.setColor(cars[i].c2);
				g.fillRect(cars[i].x, cars[i].y + rh1, rw2, rh2);
				
				g.setColor(cars[i].c1);
				g.fillOval(cars[i].x + 20, cars[i].y + rh1 + 10, c, c);
				g.fillOval(cars[i].x + 40 + c, cars[i].y + rh1 + 10, c, c);

			}
		}
	}
	public EX6_2() {
		for (int i = 0; i < 3; i++) {
			cars[i] = new Car(
					10 + ((int)(Math.random() * 300)),
					100 * (i + 1), 100 * (i+1),
					Color.red, Color.yellow);
		}
		
		setTitle("CarGame");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
		this.add(new CarPanel());
		
		Timer timer = new Timer(period, this);
		timer.start();
	}
	
	private void update() {
		for (int i = 0; i < 3; i++) {
			cars[i].x += xSpeed;
				
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	public static void main(String[] args) {
		EX6_2 f = new EX6_2();

	}

}
