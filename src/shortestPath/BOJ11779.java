package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11779 {
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}

	}

	static StringBuilder sb = new StringBuilder();
	static int N, M, start, end, count;
	static ArrayList<Edge>[] map;
	static int[] dist, parent;
	static StringTokenizer st;
	static Stack<Integer> stack = new Stack<>();
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		parent = new int[N + 1];
		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[x].add(new Edge(y, cost));
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra(start);
	
		findParent();
		
		sb.append(dist[end] + "\n");
		sb.append(count + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			int dest = cur.to;
			
			if(visit[dest]) continue;
			visit[dest] = true;
			
			for(Edge edge : map[dest]) {
				if(dist[edge.to] > dist[dest] + edge.weight) {
					dist[edge.to] = dist[dest] + edge.weight;
					queue.add(new Edge(edge.to, dist[edge.to]));
					
					parent[edge.to] = dest;
				}
			}
		}
	}
	
	static void findParent() {
		int cur = end;
		
		while(cur != start) {
			stack.push(cur);
			count++;
			cur = parent[cur];
		}
		stack.push(cur);
		count++;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
