/*
 * 14501. Επ»η
 */
package backTracking;

import java.util.Scanner;

public class BOJ14501 {

	static int N;
	static int[] T;
	static int[] P;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	static int sum = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		T = new int[N + 1];
		P = new int[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
	}

	static void pro(int k, int cost) {
		int sum = 0;
		if (k >= N + 1) {
			max = Math.max(max, cost);
		} else {

			if (k + T[k] <= N + 1) {
				pro(k + T[k], cost + P[k]);
			} else {
				pro(k + T[k], cost);
			}

			pro(k + 1, cost);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1, 0);
		System.out.println(max);
	}

}
