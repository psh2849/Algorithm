/*
 * 6603. ·Î¶Ç
 */
package backTracking;

import java.util.Scanner;

public class BOJ6603 {
	static int K = -1;
	static int[] S;
	static boolean[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);

		while (K != 0) {
			K = sc.nextInt();
			if (K == 0)
				break;
			visit = new boolean[K+1];
			S = new int[K + 1];
			for (int i = 1; i <= K; i++) {
				S[i] = sc.nextInt();
			}
			pro(1, 1);
			System.out.println();
		}
	}

	static void pro(int idx, int k) {
		if (k == 7) {
			for (int i = 1; i <= K; i++) {
				if (visit[i]) {
					System.out.print(S[i] + " ");
				}
			}
			System.out.println();
		} else {
			for (int i = idx; i <= K; i++) {
				visit[i] = true;
				pro(i + 1, k + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
