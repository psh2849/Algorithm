package union;

import java.util.*;
import java.io.*;

public class BOJ10423 {
	static class Point implements Comparable<Point> {
		int from;
		int to;
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

	static int n, m, k;
	static ArrayList<Point> list = new ArrayList<>();
	static int[] parent;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int[] power = new int[k];
		int save = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			power[i] = Integer.parseInt(st.nextToken());
			save = power[i];
		}

		for (int i = 0; i < k; i++) {
			parent[power[i]] = save;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Point(a, b, c));
		}

		Collections.sort(list);
		
		System.out.println(kruskal());
	}

	static int kruskal() {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);

			if (find(p.from) != find(p.to)) {
				result += p.weight;
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
