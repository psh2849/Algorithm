/*
 * 2470 µÎ¿ë¾×
 */
package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

	static int N;
	static int[] A;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A, 1, N + 1);

		pro();
	}

	static int lower_bound(int[] A, int L, int R, int num) {
		int res = R + 1;

		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] >= num) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}

		return res;
	}

	static void pro() {
		int res = 0;
		int v1 = 0;
		int v2 = 0;
		int best_sum = Integer.MAX_VALUE;

		for (int left = 1; left <= N - 1; left++) {
			res = lower_bound(A, left + 1, N, -A[left]);

			if (left + 1 <= res - 1 && res - 1 <= N && Math.abs(A[res - 1] + A[left]) < best_sum) {
				best_sum = Math.abs(A[res - 1] + A[left]);
				v1 = A[left];
				v2 = A[res - 1];
			}

			if (left + 1 <= res && res <= N && Math.abs(A[res] + A[left]) < best_sum) {
				best_sum = Math.abs(A[res] + A[left]);
				v1 = A[left];
				v2 = A[res];
			}

		}

		System.out.println(v1 + " " + v2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}
}
