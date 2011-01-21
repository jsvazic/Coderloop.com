import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class Euler4 {
	private static boolean isPalindrome(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; --i) {
			sb.append(str.charAt(i));
		}
		
		return str.equals(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int digits = Integer.valueOf(br.readLine().trim());
		BigInteger largestPalindrome = new BigInteger("0");
		final long highVal = (long) (Math.pow(10, digits) - 1);
		final long lowVal  = (long) (Math.pow(10, digits - 1));
		
		long a = highVal;
		while (a >= lowVal) {
			long b = highVal;
			while (b >= a) {
				BigInteger bigA = new BigInteger(String.valueOf(a));
				BigInteger bigB = new BigInteger(String.valueOf(b));
				BigInteger product = bigA.multiply(bigB);
				if (product.compareTo(largestPalindrome) <= 0) {
					break;
				}
				if (isPalindrome(product.toString())) {
					largestPalindrome = product;
				}
				--b;
			}
			--a;
		}
		System.out.println(largestPalindrome);
	}
}