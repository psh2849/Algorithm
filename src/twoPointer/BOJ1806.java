package twoPointer;

import java.util.*;
import java.io.*;

public class BOJ1806 {

	static int[] arr;
	static int n, s;
	static int ans = Integer.MAX_VALUE;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		pro();
	}

	static void pro() {
		int left = 0;
		int right = 0;
		int sum = 0;

		while (true) {
			if (sum >= s) {
				sum -= arr[left++];
				ans = Math.min(right - left + 1, ans);
			} 
			else if(right == n) break;
			else {
				sum += arr[right++];
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
