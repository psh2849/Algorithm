package etc;

import java.math.BigInteger;
import java.util.*;

public class BOJ2338 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
