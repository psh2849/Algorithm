package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15591 {

	static class Point {
		int x;
		int value;

		public Point(int x, int value) {
			this.x = x;
			this.value = value;
		}
	}

	static int N, Q;
	static ArrayList<Point>[] list;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[x].add(new Point(y, value));
			list[y].add(new Point(x, value));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			int ans = bfs(k, v);
			
			System.out.println(ans);
		}
	}

	static int bfs(int k, int v) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		queue.add(v);
		visit[v] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (Point p : list[cur]) {
				if (!visit[p.x] && p.value >= k) {
					visit[p.x] = true;
					queue.add(p.x);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
