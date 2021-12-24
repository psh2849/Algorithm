package etc;

import java.util.*;
import java.io.*;

public class BOJ14490 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] split = str.split(":");
		
		int num1 = Integer.parseInt(split[0]);
		int num2 = Integer.parseInt(split[1]);
		
		int result = gcd(num1, num2);
		num1 = num1/ result;
		num2 = num2 / result;
		
		System.out.println(num1 + ":" + num2);
		
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		
		return gcd(b, a % b);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
