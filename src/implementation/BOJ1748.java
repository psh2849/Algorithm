package implementation;

import java.io.*;

public class BOJ1748 {
	
	static int num = 10;
	static int n;
	static int plus = 1;
	static int answer = 0;
	static String str ="";
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) { 
			if(i % num == 0) {
				plus++;
				num *= 10;
			} 
			answer += plus;
		}
		
		System.out.println(answer);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}
}
