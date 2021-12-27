package graph;

import java.util.*;
import java.io.*;

public class BOJ18243 {

	static class Point {
		int to;
		int cnt;

		public Point(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
	}

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			boolean isBool = pro(i);
			if(!isBool) {
				System.out.println("Big World!");
				return;
			}
		}
		
		System.out.println("Small World!");
		
	}

	static boolean pro(int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, 0));
		visit = new boolean[n + 1];
		visit[x] = true;
		int depth = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			// System.out.println(p.to +  " " +  p.cnt);
			if (depth >= 7) {
				return false;
			}

			for (int e : list[p.to]) {
				if (visit[e])
					continue;

				visit[e] = true;
				queue.add(new Point(e, p.cnt + 1));
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
