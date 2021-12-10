package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ3079 {

	static int n, m;
	static int[] arr;
	static long max = 0;
	static long min = Long.MAX_VALUE;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i = 0; i < n; i++) { 
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		pro();
		System.out.println(min);
	}

	static void pro() {
		long left = 0;
		long right = m * max;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(int num : arr) {
				long count = mid / num;
				
				if(sum >= m) {
					break;
				}
				
				sum += count;
			}
			
			if(sum >= m) {
				min = Math.min(min, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
