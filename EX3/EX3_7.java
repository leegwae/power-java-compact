
public class EX3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr1 = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] arr2 = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		int arr1Len = arr1.length;
		int arr2Len = arr2.length;
		int ranNum1 = 0, ranNum2 = 0;
		
		for (int i = 0; i < 5; i++) {
			ranNum1 = (int)(Math.random() * arr1Len);
			ranNum2 = (int)(Math.random() * arr2Len);
			
			System.out.println(arr1[ranNum1] + "ÀÇ " + arr2[ranNum2]);
		}
		
	}

}
