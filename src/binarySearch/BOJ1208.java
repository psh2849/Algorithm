package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ1208 {
	
	static int n, s;
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}
	
	static void pro() {
		long answer = 0;
		for(int i = 0; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				long key = -(arr[i] + arr[j]);
				int lower = lowerBound(j + 1, n, key);
				
				if(lower == n || arr[lower] != key) continue;
				int upper = upperBound(j + 1, n, key);
				answer += upper - lower;
			}
		}
		
		System.out.println(answer);
	}
	
	static int lowerBound(int left, int right, long key) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] >= key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return right;
	}
	
	static int upperBound(int left, int right, long key) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] > key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
