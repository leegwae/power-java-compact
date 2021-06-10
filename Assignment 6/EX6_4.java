class Bus {
	private int max;
	private int booked;
	
	public Bus(int max) {
		booked = 0;
		this.max = max;
	}
	
	public synchronized void book(String name, int required) {
		System.out.println("Thread-"+name+" �� ������");
		
		int left = max - booked;
		
		System.out.println("������ �¼���: "+left+" ��û�¼���: " + required);
		if (required > left) {
			 System.out.println("�¼� ������ �Ұ����մϴ�.");
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("�¼��� �����մϴ�. �����ϼ���.");
			
			booked += required;
			System.out.println(required +" �¼��� ����Ǿ���.");
		}
		
		System.out.println("Thread-"+name+" �� �����ϴ�");
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
