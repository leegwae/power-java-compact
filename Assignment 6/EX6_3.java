import java.util.ArrayList;

class RandomList<T> {
	private ArrayList<T> list;
	
	public RandomList(int s) {
		list = new ArrayList<T>(s);
	}
		
	public void add(T item) { list.add(item); } 		// 항목 추가 
	public T select() { return list.get(getRandomInt()); } // 랜덤하게 선택하여 반환
	public int size() { return list.size(); }
	public T get(int index) { return list.get(index); }
	
	private int getRandomInt() {
		return (int)(Math.random() * list.size());
	}

}

public class EX6_3 {

	public static void main(String[] args) {
		RandomList<Integer> rla = new RandomList<Integer>(2);
		
		rla.add(10);
		rla.add(20);
		rla.add(50);
		
		for(int i = 0 ; i < rla.size(); i++) {
			System.out.println(rla.get(i));
			System.out.println(rla.select());
		}
		
		RandomList<String> rlb = new RandomList<String>(1);
		
		rlb.add("We");
		rlb.add("Are");
		rlb.add("The");
		rlb.add("World");
		
		for(int i = 0 ; i < rlb.size(); i++) {
			System.out.println(rlb.get(i));
			System.out.println(rlb.select());
		}
	
	} 
}
