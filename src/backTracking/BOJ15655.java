package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15655 {

	static int N, M;
	static int[] A;
	static int[] visited;
	static int[] check;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		visited = new int[M + 1];
		check = new int[N + 1];
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
	}

	static void pro(int k, int start) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(visited[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i = start; i <= N; i++) {
				if (check[i] == 1) continue;
					
				visited[k] = A[i];
				check[i] = 1;
				pro(k + 1, i + 1);
				visited[k] = 0;
				check[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1, 1);
	}

}