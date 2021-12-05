package etc;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ1271 {
	
	static void input() throws IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.divide(b));
		System.out.println(a.mod(b));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
