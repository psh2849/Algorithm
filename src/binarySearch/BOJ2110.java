package binarySearch;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ2110 {

	static int N, M;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		pro();
	}

	static void pro() {
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N - 1] - arr[0];
		int d = 0;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = arr[0];
			int cnt = 1;
			
			for(int i = 1; i < N; i++) {
				d = arr[i] - start;
				if(d >= mid) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= M) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
