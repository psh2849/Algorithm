package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int end;
	int weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
}

public class BOJ10282 {

	private static int tc, n, d, c;
	private static int a, b, s;
	private static int[] dist;
	private static ArrayList<Node>[] list;
	private static final int INF = 100000000;
	private static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		while (tc-- > 0) {
			n = sc.nextInt();
			d = sc.nextInt();
			c = sc.nextInt();

			check = new boolean[n + 1];
			dist = new int[n + 1];
			list = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				s = sc.nextInt();

				list[b].add(new Node(a, s));
			}

			dijkstra(c);
			
			int count = 0;
			int time = 0;
			
			for(int i = 1; i <= n; i++) {
				if(dist[i] != INF) {
					count++;
					time = Math.max(time, dist[i]);
				}
			}
			
			System.out.println(count + " " + time);
		}

	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.clear();
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		queue.add(new Node(start, 0));
		
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int end = curNode.end;

			if(check[end] == true) continue;
			check[end] = true;
			
			for (Node node : list[end]) {
				if (dist[node.end] > dist[end] + node.weight) {
					dist[node.end] = dist[end] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}
