/*
 * 15656. N°ú M (7)
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {

	static int N, M;
	static int[] visited;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		visited = new int[M + 1];
		A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
	}

	static void dfs(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(visited[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				visited[k] = A[i];
				dfs(k + 1);
				visited[k] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dfs(1);
		System.out.println(sb);
	}

}
