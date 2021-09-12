package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14496 {

	static int N, M;
	static int start, dest;
	static ArrayList<Integer>[] adj;
	static int[] dist;
	static boolean[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);

		start = sc.nextInt();
		dest = sc.nextInt();

		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adj[x].add(y);
			adj[y].add(x);
		}

		bfs(start, dest);
	}

	static void bfs(int start, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int j : adj[cur]) {
				if(visit[j]) continue;
				
				visit[j] = true;
				dist[j] = dist[cur] + 1;
				queue.add(j);
			}
		}
		
		if(dist[dest] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dist[dest]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
