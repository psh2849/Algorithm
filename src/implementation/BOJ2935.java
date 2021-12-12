package implementation;

import java.math.BigInteger;
import java.util.*;

public class BOJ2935 {

	static void input() {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		String op = sc.next();
		BigInteger b= sc.nextBigInteger();
	
		if(op.charAt(0) == '+') {
			System.out.println(a.add(b));
		} else {
			System.out.println(a.multiply(b));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
