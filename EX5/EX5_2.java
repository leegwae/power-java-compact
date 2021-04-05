class Plane{
	// ============= [ private fields ] =========================
	private String manufacturer;
	private String model;
	private int passengers;

	// ============= [ static fields ] =========================
	static int planes = 0;
	
	public Plane() {
		this.manufacturer = null;
		this.model = null;
		this.passengers = 0;
		
		planes++;
	}
	
	public Plane(String manufacturer, String model, int passengers) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.passengers = passengers;
	}
	
	public String getManufacturer() { return manufacturer; }
	public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
	
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	
	public int getPassengers() { return passengers; }
	public void setPassengers(int passengers) { this.passengers = passengers; }
	
	static public int getPlanes() { return planes; }
	
	public void print() {
		System.out.println("제작사: "+manufacturer+" 모델: " +model+" 최대승객: "+ passengers+"명");
	}
}
public class EX5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Plane p1 = new Plane();
		Plane p2 = new Plane();
		Plane p3 = new Plane();
		
		p1.setManufacturer("에어버스");
		p1.setModel("A380");
		p1.setPassengers(500);
		
		p2.setManufacturer("보잉");
		p2.setModel("B777");
		p2.setPassengers(400);
		
		p3.setManufacturer("보잉");
		p3.setModel("B747");
		p3.setPassengers(300);
	
		p1.print();
		p2.print();
		p3.print();

		count = Plane.getPlanes();
		System.out.println("항공기 대수=" + count+"대");
	}

}
