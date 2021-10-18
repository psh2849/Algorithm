package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {
	static class Point implements Comparable<Point> {
		int start;
		int dest;
		int value;

		public Point(int start, int dest, int value) {
			this.start = start;
			this.dest = dest;
			this.value = value;
		}

		public int compareTo(Point p) {
			if (p.value >= this.value)
				return -1;
			else
				return 1;
		}
	}

	static int v, e, answer;
	static int s, d, cost;
	static int[] parent;
	static PriorityQueue<Point> queue = new PriorityQueue<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());

			queue.add(new Point(s, d, cost));
		}

		pro();
		
		System.out.println(answer);
	}

	static void pro() {
		for (int i = 0; i < e; i++) {
			Point p = queue.poll();
			int a = find(p.start);
			int b = find(p.dest);

			if (a == b)
				continue;
			union(a, b);
			answer += p.value;
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			parent[a] = find(parent[a]);
		}

		return parent[a];
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[b] = a;
		} else {
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
