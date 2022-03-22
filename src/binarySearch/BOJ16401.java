package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ16401 {
	
	static int n, m, max;
	static int[] snack;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		snack = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, snack[i]);
		}
		
		pro();
	}
	
	static void pro() {
		int left = 1;
		int right = max;
		int result = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			
			for(int s : snack) {
				if(s < mid) continue;
				
				int num = s / mid;
				sum += num;
			}
			
			if(n > sum) {
				right = mid - 1;
			} else {
				result = Math.max(result, mid);
				left = mid + 1;
			}
			
			
		}
		
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
