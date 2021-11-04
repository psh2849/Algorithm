package graph;

import java.util.*;
import java.io.*;

public class BOJ1967 {

	static class Point {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static int n, index;
	static ArrayList<Point>[] list;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		visit = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, weight));
			list[b].add(new Point(a, weight));
		}
		
		visit[1] = true;
		dfs(1, 0);

		visit = new boolean[n + 1];
		visit[index] = true;
		dfs(index, 0);
		System.out.println(max);
	}

	static void dfs(int k, int cnt) {
		if (max < cnt) {
			max = cnt;
			index = k;
		}

		for (Point p : list[k]) {
			if (!visit[p.to]) {
				visit[p.to] = true;
				dfs(p.to, cnt + p.weight);
				visit[p.to] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
