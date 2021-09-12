/*
 * 15654 N°úM(5)
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static int[] selected;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1];
		selected = new int[M + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
	}

	static void pro(int idx, int start) {
		if (idx == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= N; i++) {
				if (visit[i])
					continue;

				selected[idx] = arr[i];
				visit[i] = true;
				pro(idx + 1, i + 1);
				selected[idx] = 0;
				visit[i] = false;

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1, 1);
	}

}
