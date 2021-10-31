package etc;

import java.io.*;

public class BOJ1789 {

	static long num;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Long.parseLong(br.readLine());
		
		long cnt = 0;
		while (num >= 0) {
			cnt++;
			num -= cnt;
		}
		
		System.out.println(cnt - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
