package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ14284 {

	static class Point implements Comparable<Point> {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}

	static int n, m, s, t;
	static ArrayList<Point>[] list;
	static int[] dist;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dist = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[start].add(new Point(dest, value));
			list[dest].add(new Point(start, value));
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		pro();
	}

	static void pro() {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(s, 0));
		dist[s] = 0;
		boolean[] visit = new boolean[n + 1];
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(visit[p.to]) continue;
			
			visit[p.to] = true; 
			for (Point e : list[p.to]) {
				if (dist[e.to] > dist[p.to] + e.weight) {
					dist[e.to] = dist[p.to] + e.weight;
					queue.add(new Point(e.to, dist[e.to]));
				}
			}
		}
		
		System.out.println(dist[t]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
