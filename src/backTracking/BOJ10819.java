/*
 * 10819 차이를 최대로
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10819 {

	static int N;
	static int[] A;
	static int[] visit;
	static int[] selected;
	static int max = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		visit = new int[N + 1];
		selected = new int[N + 1];
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A, 1, N);
	}

	static void pro(int k) {
		if (k == N + 1) {
			cal();
		} else {
			for (int i = 1; i <= N; i++) {
				if (visit[i] == 1)
					continue;

				selected[k] = A[i];
				visit[i] = 1;
				pro(k + 1);
				visit[i] = 0;
			}
		}
	}

	static void cal() {
		int sum = 0;
		for (int i = 1; i < N; i++) {
			sum += Math.abs(selected[i] - selected[i + 1]);
		}

		max = Math.max(max, sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1);
		System.out.println(max);
	}

}
