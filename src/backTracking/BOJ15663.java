/*
 * 15663. N과M(9)
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15663 {

	static int N, M;
	static int[] visit;
	static int[] num;
	static int[] check;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N + 1];
		visit = new int[M + 1];
		check = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
	}

	static void pro(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i] + " ");
			}
			System.out.println();
		} else {
			int last_cand = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i] == 1)
					continue;
				if (num[i] == last_cand)
					continue;
				last_cand = num[i];
				visit[k] = num[i];
				check[i] = 1;
				pro(k + 1);

				visit[k] = 0;
				check[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1);
	}

	// 중복을 허용하면서 순서 있게 나열.
	public static void pro2(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i]);
			}
			System.out.println();
		} else {
			for (int i = 1; i <= N; i++) {
				visit[k] = i;
				pro2(k + 1);
				visit[k] = 0;
			}
		}
	}

	// 중복을 허용하지 않고 순서 있게 나열.
	public static void pro3(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i]);
			}
			System.out.println();
		} else {
			for (int i = 1; i <= N; i++) {
				if (check[i] == 1)
					continue;
				visit[k] = i;
				check[i] = 1;
				pro3(k + 1);
				visit[k] = 0;
				check[i] = 0;
			}
		}
	}

	// 중복을 허용하면서 M개를 고르기
	public static void pro4(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i]);
			}
			System.out.println();
		} else {
			int start = visit[k - 1];
			if (start == 0)
				start = 1;
			for (int i = start; i <= N; i++) {
				visit[k] = i;
				pro(k + 1);
				visit[k] = 0;
			}
		}
	}

	// 중복을 허용하지 않으면서 M개를 고르는 방법.
	public static void pro5(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visit[i]);
			}
			System.out.println();
		} else {
			int start = visit[k - 1] + 1;
			if (start == 0)
				start = 1;
			for (int i = start; i <= N; i++) {
				if(check[i] == 1) continue;
				
				visit[k] = i;
				check[i] = 1;
				pro(k+1);
				visit[k] = 0;
				check[i] = 0;
			}
		}
	}

}
