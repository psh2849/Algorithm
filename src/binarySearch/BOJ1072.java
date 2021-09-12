package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
	static long N, M, Z;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		Z = (M * 100 / N);
		
		if(Z >= 99) {
			System.out.println(-1);
			return;
		}
		pro();
	}
	
	static void pro() {
		long left = 0;
		long mid = 0;
		long right = N;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(Z < 100 * (M + mid) / (N + mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
