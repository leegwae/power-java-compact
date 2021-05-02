class Rectangle {
	  int width, height;

	  public Rectangle(int w, int h) {
		  width = w;
		  height = h;
	}
}

class ColorRectangle extends Rectangle {
	private String color;
	
	public ColorRectangle(int width, int height, String color) {
		super(width, height);
		this.color = color;
	}
	
	public void print() {
		System.out.println("가로: "+ width);
		System.out.println("세로: "+ height);
		System.out.println("색상: "+ color);
	}
}
public class EX4_2 {

	public static void main(String[] args) {
		ColorRectangle cr = new ColorRectangle(100, 100, "blue");
		cr.print();
	}

}