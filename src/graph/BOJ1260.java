/*
 * 1260. DFS¿Í BFS 
 */

package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adj[x].add(y);
			adj[y].add(x);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		pro();
	}

	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');

		for (int y : adj[x]) {
			if (visit[y] == true)
				continue;

			dfs(y);
		}
	}

	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(x);
		visit[x] = true;

		while (!queue.isEmpty()) {
			x = queue.poll();
			sb.append(x).append(' ');

			for (int y : adj[x]) {
				if (visit[y] == true)
					continue;

				queue.add(y);
				visit[y] = true;
			}
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}
		bfs(V);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}