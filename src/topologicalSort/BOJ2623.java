/*
 * 2623. 음악프로그램
 */
package topologicalSort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2623 {
	static int N, M;
	static int[] indeg;
	static int[][] adj;
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		indeg = new int[N + 1];
		adj = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int start = sc.nextInt();
			for (int j = 0; j < x - 1; j++) {
				int end = sc.nextInt();
				if (adj[start][end] == 0) {
					adj[start][end] = 1;
					indeg[end]++;
				}

				start = end;
			}
		}
	}

	static void pro() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node + "\n");
			for (int y = 1; y < adj.length; y++) {
				if(adj[node][y] == 1) {
					indeg[y]--;
					if (indeg[y] == 0) {
						queue.add(y);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(indeg[i] == 1) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
