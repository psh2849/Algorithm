/*
 * 15650. N°úM(2)
 */
package backTracking;

import java.util.Scanner;

public class BOJ15650 {

	static int N, M;
	static int[] used, selected;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		used = new int[N + 1];
		selected = new int[M + 1];
	}

	static void pro(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
		} else {
			int start = selected[k - 1];
			if (start == 0)
				start = 1;

			for (int i = start; i <= N; i++) {
				if(used[i] == 1) continue;
				
				selected[k] = i;
				used[i] = 1;
				pro(k+1);
				selected[k] = 0;
				used[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1);
	}

}
