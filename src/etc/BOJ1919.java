package etc;

import java.util.Scanner;

public class BOJ1919 {
	
	static int[] ch1 = new int[26];
	static int[] ch2 = new int[26];
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		for(int i = 0; i < str1.length(); i++) {
			char ch = (char) (str1.charAt(i) - 97);
			
			ch1[ch]++;
		}
		
		for(int i = 0; i < str2.length(); i++) {
			char ch = (char) (str2.charAt(i) - 97);
			
			ch2[ch]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < ch1.length; i++) {
			cnt += Math.abs(ch1[i] - ch2[i]);
		}
		
		System.out.println(cnt);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
