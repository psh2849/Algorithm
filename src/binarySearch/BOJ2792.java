package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ2792 {

	static int n, m, max;
	static int[] color;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		color = new int[m];
		for (int i = 0; i < m; i++) {
			color[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, color[i]);
		}

		pro();
	}

	static void pro() {
		int min = Integer.MAX_VALUE;
		int left = 1;
		int right = max;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			
			for (int c : color) {
				int num = 0;

				if (c % mid == 0) {
					num = c / mid;
				} else {
					num = c / mid + 1;
				}
				
				sum += num;
			}
			
			if(n >= sum) {
				min = Math.min(min, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
