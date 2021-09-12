package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {

	static int N, M, K, start;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int[] dist;
	static boolean flag = false;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		dist = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			adj[s].add(d);
		}

		bfs(start);

		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i + "\n");
				flag = true;
			}
		}
		
		if(flag == false) {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}

	static void bfs(int s) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		visit[s] = true;
		dist[s] = 0;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int y : adj[node]) {
				if (visit[y])
					continue;

				queue.add(y);
				visit[y] = true;
				dist[y] = dist[node] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
