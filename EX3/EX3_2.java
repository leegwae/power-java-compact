
public class EX3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j = 0;
		
		// �Ҽ� : 1�� �ڱ��ڽ����� �������� ���� �������� 0�̴�.
		System.out.print("2���� 100������ �Ҽ�: ");
		for (i = 2; i <= 100; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) System.out.print(j + " ");
		}
	}

}
