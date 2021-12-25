package etc;

import java.util.*;
import java.io.*;

public class BOJ9996 {

	static int n;
	static String pattern;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		pattern = br.readLine();
		String[] split = pattern.split("\\*");
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			if(str.length() < pattern.length() - 1) {
				System.out.println("NE");
				continue;
			}
			
			String front = str.substring(0, split[0].length());
			String back = str.substring(str.length() - split[1].length(), str.length());
			
			if(front.equals(split[0]) && back.equals(split[1])) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
