package union;

import java.util.*;
import java.io.*;

public class BOJ1647 {

	static class Point implements Comparable<Point> {
		int to;
		int from;
		int weight;

		public Point(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}

	static int max = Integer.MIN_VALUE;
	static int n, m;
	static ArrayList<Point> list = new ArrayList<>();
	static int[] parent;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.add(new Point(a, b, v));
		}

		Collections.sort(list);
		System.out.println(kruskal() - max);
	}
	
	static int kruskal() {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			
			if (find(p.from) != find(p.to)) {
				result += p.weight;
				max = Math.max(max, p.weight);
				union(p.from, p.to);
			}
		}
		
		return result;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
