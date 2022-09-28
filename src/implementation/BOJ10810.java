package implementation;

import java.util.*;
import java.io.*;

public class BOJ10810 {

	static int n, m;
	static int[] basket;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		basket = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			for (int j = start; j <= end; j++) {
				basket[j] = number;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(basket[i] + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
