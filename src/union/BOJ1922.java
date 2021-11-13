package union;

import java.util.*;
import java.io.*;

public class BOJ1922 {

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

	static int n, m;
	static ArrayList<Point> list = new ArrayList<>();;
	static int[] parent;
	static boolean[] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		visit = new boolean[n + 1];
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list.add(new Point(a, b, value));
		}

		Collections.sort(list);
		System.out.println(kruskal());
	}

	static int kruskal() {
		int answer = 0;
		
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);

			if (find(p.from) != find(p.to)) {
				answer += p.weight;
				union(p.from, p.to);
			}
		}
		
		return answer;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
