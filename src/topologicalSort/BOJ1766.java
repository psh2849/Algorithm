package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1766 {
	static ArrayList<Integer>[] adj;
	static int[] indeg;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indeg = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			indeg[y]++;
		}

	}

	static void pro() {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int info = queue.poll();
			sb.append(info + " ");
			
			for (int y : adj[info]) {
				indeg[y]--;
				if(indeg[y] == 0) {
					queue.add(y);
				}
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
