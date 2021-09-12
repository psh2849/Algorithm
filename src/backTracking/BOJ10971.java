/*
 * 10971 외판원 순회2
 */
package backTracking;

import java.util.Scanner;

public class BOJ10971 {
	static int N;
	static int[][] W;
	static int[] visit;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = new int[N + 1][N + 1];
		visit = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				W[i][j] = sc.nextInt();
			}
		}

		pro(1, 1, 0);
	}

	static void pro(int start, int now, int count) {
		if (start == now && count == N) {
			min = Math.min(sum, min);
		} else {
			for (int i = 1; i <= N; i++) {
				if (visit[i] == 0 && W[now][i] > 0) {
					visit[i] = 1;
					sum += W[now][i];
					pro(start, i, count + 1);
					visit[i] = 0;
					sum -= W[now][i];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		System.out.println(min);
	}

}
