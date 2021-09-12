/*
 * 15666. N°úM(12)
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15666 {
	static int N, M;
	static int[] visit;
	static int[] A;
	static int[] used;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N + 1];
		visit = new int[M + 1];
		used = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
	}

	static void pro(int k, int start) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i] + " ");
			}
			System.out.println();
		} else {
			int num = 0;
			for (int i = start; i <= N; i++) {
				if (num == A[i])
					continue;
				
				visit[k] = A[i];
				pro(k + 1, i);
				visit[k] = 0;
				num = A[i];
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1, 1);
	}

}
