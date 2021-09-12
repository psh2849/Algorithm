package etc;

import java.util.Scanner;

public class BOJ10808 {
	
	static int[] check;
	static String str;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		check = new int[26];
		
		for(int i =0; i < str.length(); i++) {
			int num = str.charAt(i) - 'a';
			
			check[num]++;
		}
		
		for(int i =0; i < check.length; i++) {
			System.out.print(check[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}
}
