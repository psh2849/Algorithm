package programmers_lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO2 {
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

	static boolean[] visit;
	static int[] dist;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Point>[] list;

	static int solution(int n, int[][] edge) {
		int answer = 0;

		visit = new boolean[n + 1];
		dist = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			list[edge[i][0]].add(new Point(edge[i][1], 1));
			list[edge[i][1]].add(new Point(edge[i][0], 1));
		}

		dijkstra(1, n);
		
		for(int i = 1; i <= n; i++) {
			if(max < dist[i]) {
				max = dist[i];
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(max == dist[i]) {
				answer++;
			}
		}
		
		return answer;
	}

	static void dijkstra(int start, int n) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> queue = new PriorityQueue<>();
		dist[start] = 0;
		queue.add(new Point(start, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (visit[p.to])
				continue;
			visit[p.to] = true;

			for (Point edge : list[p.to]) {
				if (dist[edge.to] >= dist[p.to] + edge.weight) {
					dist[edge.to] = dist[p.to] + edge.weight;
					queue.add(new Point(edge.to, dist[edge.to]));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		solution(6, edge);
	}

}
