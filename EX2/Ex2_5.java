public class Ex2_5 {

	public static void main(String[] args) {
		int x = 2;
		String y, z, a, b;

		y = Integer.toHexString((x << 8));
		z = Integer.toHexString((x >> 8));
		a = Integer.toHexString((x & 0xff));
		b = Integer.toHexString((x ^ 0xff));
		System.out.println("y="+y);
		System.out.println("z="+z);
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

}
