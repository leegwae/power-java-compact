class Bus {
	private int max;
	private int booked;
	
	public Bus(int max) {
		booked = 0;
		this.max = max;
	}
	
	public synchronized void book(String name, int required) {
		System.out.println("Thread-"+name+" 가 들어왔음");
		
		int left = max - booked;
		
		System.out.println("가능한 좌석수: "+left+" 요청좌석수: " + required);
		if (required > left) {
			 System.out.println("좌석 예약이 불가능합니다.");
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("좌석이 가능합니다. 예약하세요.");
			
			booked += required;
			System.out.println(required +" 좌석이 예약되었음.");
		}
		
		System.out.println("Thread-"+name+" 가 나갑니다");
		System.out.println("------------------------------------");
	}
	
}

class Client extends Thread{
	private String name;
	private Bus bus;
	private int requireCount;
	
	public Client(Bus bus, String name, int requireCount) {
		this.bus = bus;
		this.name = name;
		this.requireCount = requireCount;
	}
	
	public void run() {
		bus.book(name, requireCount);
	}
}
public class EX6_4 {
	public static void main(String[] args) {
		Bus bus = new Bus(10);
		(new Client(bus, "A", 5)).start();
		(new Client(bus, "B", 4)).start();
		(new Client(bus, "C", 2)).start();
	}
}
