package etc;

import java.util.*;
import java.io.*;

public class BOJ5586 {
	
	static String str;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		int ans1 = 0;
		int ans2 = 0;
		for(int i = 0; i < str.length() - 2; i++) {
			if(str.charAt(i) == 'J') {
				if(str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
					ans1++;
				}
			}
			
			if(str.charAt(i) == 'I') {
				if(str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
					ans2++;
				}
			}
		}
		
		System.out.println(ans1);
		System.out.println(ans2);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
