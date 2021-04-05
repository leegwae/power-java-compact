class Dice {
	private int value;
	
	public Dice() {
		this.value = 0;
	}
	
	public void roll() {
		this.value = (int)(Math.random() * 6 + 1);
	}

	public int getValue() { return this.value; }
	public void setValue(int value) { this.value = value; }
}

public class DiceGame{
	
	public static void main(String[] args) {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		int value1 = 0, value2 = 0;
		int i = 0;
		do {
			dice1.roll();
			value1 = dice1.getValue();
			
			dice2.roll();
			value2 = dice2.getValue();
			
			System.out.println("주사위1="+value1+" 주사위2="+value2);
			
			i++;
			
			if ((value1 + value2) == 2) {
				break;
			}
		} while(true);
		
		System.out.println("(1,1)이 나오는데 걸린 회수 = "+i);
	}
}
