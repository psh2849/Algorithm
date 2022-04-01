package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ9694 {

	static class Point implements Comparable<Point> {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Point o) {
			return weight - o.weight;
		}
	}

	static int t;
	static int n, m;
	static ArrayList<Point>[] list;
	static int[] dist;
	static int[] prev;
	static int count = 1;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			prev = new int[m + 1];
			Arrays.fill(prev, -1);
			
			list = new ArrayList[m + 1];
			for (int i = 0; i < m; i++) {
				list[i] = new ArrayList<>();
			}
			dist = new int[m];
			for (int i = 0; i < m; i++) {
				dist[i] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				list[start].add(new Point(dest, weight));
				list[dest].add(new Point(start, weight));
			}

			pro();
		}
	}

	static void pro() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		Stack<Integer> stack = new Stack<>();
		boolean[] visit = new boolean[n + 1];

		queue.add(new Point(0, 0));
		dist[0] = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
		
			if (visit[p.to]) continue;
			visit[p.to] = true;
			
			for (Point e : list[p.to]) {
				if(dist[e.to] > dist[p.to] + e.weight) {
					dist[e.to] = dist[p.to] + e.weight;
					queue.add(new Point(e.to, dist[e.to]));
					prev[e.to] = p.to;
				}
			}
		}
		
		System.out.print("Case #" + count++ + ": ");
		if(dist[m - 1] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			for(int i = m - 1; i >= 0;) {
				stack.push(i);
				i = prev[i];
			}
			
			while(!stack.empty()) {
				System.out.print(stack.pop() + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
