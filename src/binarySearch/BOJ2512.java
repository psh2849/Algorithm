package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {

	static int N, M;
	static int[] budget;
	static int min = Integer.MAX_VALUE;
	static int b_sum = 0;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		budget = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, budget[i]);
		}

		M = Integer.parseInt(br.readLine());

		if (min > M) {
			System.out.println(M);
		} else {
			pro();
		}
	}

	static void pro() {
		Arrays.sort(budget);

		int left = 0;
		int right = budget[N - 1];
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 0; i < budget.length; i++) {
				if (budget[i] <= mid) {
					sum += budget[i];
				} else {
					sum += mid;
				}
			}

			if (sum > M) {
				right = mid - 1;
			} else {
				ans = Math.max(ans, mid);
				left = mid + 1;
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
