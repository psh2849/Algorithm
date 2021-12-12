package etc;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1371 {
	static int[] write = new int[26];
	static int max = 0;
	static void input() throws Exception{
		Scanner sc = new Scanner(System.in);
	
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ' ') continue;
				
				write[str.charAt(i) - 'a']++;
				max = Math.max(max, write[str.charAt(i) - 'a']);
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(write[i] == max) {
				System.out.print((char)(i + 'a'));
			}
		}
		
		sc.close();
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		input();
	}

}
