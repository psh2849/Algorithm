package implementation;

import java.util.*;
import java.io.*;

public class BOJ2953 {

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int idx = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (max < a + b + c + d) {
				max = a + b + c + d;
				idx = i + 1;
			}
		}
		
		System.out.println(idx + " " + max);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
