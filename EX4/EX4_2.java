class Complex {
	int real;
	int imag;
	
	public Complex(int real, int imag) {
		this.real = 0;
		this.imag = 0;
	}
	
	public void setReal(int real) { this.real = real; }
	public void setImage(int image) { this.imag = image; }
	
	public void print() {
		System.out.println(real + "+" + imag + "i");
	}
}
public class EX4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex num = new Complex(0, 0);
		
		num.setReal(10);
		num.setImage(20);
		num.print();
	}
}