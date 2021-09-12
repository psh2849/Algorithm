package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10953 {

	static int N;
	static String str;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] split = str.split(",");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			sb.append(a + b + "\n");
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
