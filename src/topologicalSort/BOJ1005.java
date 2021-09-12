/*
 * 1005 ACM Craft (위상정렬) 3
 */
package topologicalSort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1005 {

	static int[] T;
	static int N, K;
	static int D;
	static ArrayList<Integer>[] adj;
	static int[] indeg;
	static int[] T_done;
	static Scanner sc = new Scanner(System.in);
	static void input() {
	
		N = sc.nextInt();
		K = sc.nextInt();
		adj = new ArrayList[N + 1];
		indeg = new int[N + 1];
		T_done = new int[N + 1];
		T = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			T[i] = sc.nextInt();
		}

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adj[x].add(y);
			indeg[y]++;
		}

	}

	static void pro() {

		Deque<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				queue.add(i);
				T_done[i] = T[i];
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int y : adj[x]) {
				indeg[y]--;
				if(indeg[y] == 0) {
					queue.add(y);
				}
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}
		
		int w = sc.nextInt();
		System.out.println(T_done[w]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Q = sc.nextInt();

		while (Q-- > 0) {
			input();
			pro();
		}

	}

}
