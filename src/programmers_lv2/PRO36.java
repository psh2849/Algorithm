/*
 * https://programmers.co.kr/learn/courses/30/lessons/12978
 */
package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO36 {
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

	static ArrayList<Point>[] map;
	static int[] dist;
	static boolean[] visit;

	static int solution(int N, int[][] road, int K) {
		int answer = 0;
		dist = new int[N + 1];
		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < road.length; i++) {
			map[road[i][0]].add(new Point(road[i][1], road[i][2]));
			map[road[i][1]].add(new Point(road[i][0], road[i][2]));
		}

		dijkstra(N);
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] <= K) {
				answer++;
			}
		}
	
		return answer;
	}

	static void dijkstra(int N) {
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(1, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int dest = p.to;
			if (visit[dest])
				continue;
			visit[dest] = true;
			for (Point e : map[dest]) {
				if (dist[e.to] > dist[dest] + e.weight) {
					dist[e.to] = dist[dest] + e.weight;
					queue.add(new Point(e.to, dist[e.to]));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		solution(5, road, 3);
	}

}
