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
			
			int front = str.indexOf(split[0]);
			int back = str.indexOf(split[1]);
			
			if(front == -1 || back == -1) {
				System.out.println("NE");
				continue;
			}
			
			if(front < back) {
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
