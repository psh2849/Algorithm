/*
 * 14938 서강그라운드
 */
package shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge1 {
	int to, weight;

	public Edge1(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

class Info1 {
	int idx;
	int dist;

	public Info1(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
}

public class BOJ14938 {
	static int N, M, R; // N은 지역 개수, M은 수색범위, R은 길의 개수
	static int[] items;
	static ArrayList<Edge1>[] city;
	static int max = Integer.MIN_VALUE;
	static int[] dist;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		dist = new int[N + 1];
		items = new int[N + 1];
		city = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			city[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			items[i] = sc.nextInt();
		}

		for (int i = 1; i <= R; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int len = sc.nextInt();
			
			city[x].add(new Edge1(y, len));
			city[y].add(new Edge1(x, len));
		} 
	
		
		for (int i = 1; i <= N; i++) {
			int item_count = 0;
			dijkstra(i);
			for(int j = 1; j <= N; j++) {
				if(dist[j] > M) continue;
				
				item_count += items[j];
				
			}
			max = Math.max(max, item_count);
		}

		System.out.println(max);

	}

	private static void show_dist() {
		// TODO Auto-generated method stub
		for(int i = 1; i<= N; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}

	static void dijkstra(int start) {
		for (int i = 1; i <= N; i++) {
			if (i == start)
				dist[i] = 0;
			else
				dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Info1> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
		pq.add(new Info1(start, 0));
		
		while(!pq.isEmpty()) {
			Info1 info = pq.poll();
			
			if(info.dist > dist[info.idx]) continue;
			
			for(Edge1 edge : city[info.idx]) {
				if(edge.weight + dist[info.idx] < dist[edge.to]) {
					dist[edge.to] = edge.weight + dist[info.idx];
					pq.add(new Info1(edge.to, dist[edge.to]));
				}
			}
		}
		// show_dist();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		
	}

}
