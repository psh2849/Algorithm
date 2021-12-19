package etc;

import java.util.*;
import java.io.*;

public class BOJ4458 {
	
	static int n;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			String s = "";
			if(str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
				char ch = (char) (str.charAt(0) - 32);
				
				str = str.substring(1, str.length());
				s += ch;
				s += str;
				System.out.println(s);
			} else {
				System.out.println(str);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
