package graph;

import java.util.*;
import java.io.*;

public class BOJ11501 {

	static int t, n;
	static long[] stock;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			stock = new long[n];
			long max = 0;
			long gain = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = n - 1; i >= 0; i--) {
				if(stock[i] > max) {
					max = stock[i];
				} else {
					gain += (max - stock[i]);
				}
			}
			
			System.out.println(gain);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
