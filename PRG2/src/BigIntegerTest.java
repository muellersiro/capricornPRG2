import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("44444444444444444444");
		BigInteger b2 = new BigInteger("22222222222222222222");
		
		System.out.println(b1.add(b2));
		System.out.println(b2.add(b2).equals(b1));
	}

}
