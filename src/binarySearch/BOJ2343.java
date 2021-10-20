package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
	
	static long min = Long.MAX_VALUE;
	static int N, M, sum;
	static long[] arr;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		binarySearch();
	}
	
	static void binarySearch() {
		long left = 1;
		long right = sum;
		long sumlay = 0;
		int count = M;
		boolean isBool = true;
		while(left <= right) {
			long mid = (left + right) / 2;
			for(int i = 0; i < N; i++) {
				sumlay += arr[i];
				if(sumlay > mid) {
					count--;
					i--;
					sumlay = 0;
				} 
				if(count <= 0) {
					break;
				}
			}
		
			if(count <= 0) {
				isBool = false;
			}
		
			if(isBool) {
				min = Math.min(min, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			isBool = true;
			count = M;
			sumlay = 0;
		}
		
		System.out.println(min);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
