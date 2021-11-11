package implementation;

import java.io.*;

public class BOJ1977 {

	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 1; i <= m; i++) {
			int num = i * i;
			if (num >= n && num <= m) {
				sum += num;
				min = Math.min(num, min);
			}
			
			if (num > m)
				break;
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
