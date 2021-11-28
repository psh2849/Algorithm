package binarySearch;

import java.io.*;

public class BOJ1094 {

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int num = 64;
		int count = 0;
		
		while(x > 0) {
			if(num > x) num /= 2;
			else {
				count++;
				x-=num;
			}
		}
		
		System.out.println(count);
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
