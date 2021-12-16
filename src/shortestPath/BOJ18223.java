package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ18223 {
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

	static int v, e, p;
	static ArrayList<Point>[] list;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}

		int[] arr1 = dijkstra(1);
		int[] arr2 = dijkstra(p);
	
		if (arr1[v] >= arr1[p] + arr2[v]) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}
	}

	static int[] dijkstra(int start) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		int[] dist = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		queue.add(new Point(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (Point next : list[p.to]) {
				if (dist[next.to] > dist[p.to] + next.weight) {
					dist[next.to] = dist[p.to] + next.weight;
					queue.add(new Point(next.to, dist[next.to]));
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
