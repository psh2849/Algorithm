package union;

import java.util.*;
import java.io.*;

public class BOJ14621 {
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

	static int n, m, cnt;
	static int[] parent;
	static int[] school;
	static ArrayList<Point> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		school = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			String str = st.nextToken();

			if (str.charAt(0) == 'W') {
				school[i] = 1;
			} else {
				school[i] = 2;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list.add(new Point(a, b, value));
		}

		Collections.sort(list);
		int answer = kruskal();
		System.out.println(cnt != n - 1 ? -1 : answer);
	}

	static int kruskal() {
		int result = 0;

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			if ((find(p.from) != find(p.to)) && (school[p.from] != school[p.to])) {
				cnt++;
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
