package implementation;

import java.io.*;

public class BOJ1747 {
	
	static void input() throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if(num == 1) {
			System.out.println(2);
			return;
		}
		
		for(int i = num; ; i++) { 
			if(isPrime(i) && isPalindrome(i)) {
				System.out.println(i);
				return;
			}
		}
		
	}
	
	static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isPalindrome(int num) {
		String str = Integer.toString(num);
	
		for(int i = 0; i <= str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
