package implementation;

import java.io.*;

public class BOJ2576 {
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 100;
		int sum = 0;
		for(int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num % 2 != 0) {
				sum += num;
				min = Math.min(min, num);
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
