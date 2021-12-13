package sorting;

import java.util.*;
import java.io.*;

public class BOJ2887 {

	static class Point {
		int num;
		int x;
		int y;
		int z;

		public Point(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}

	static int n;
	static int[] parent;
	static Point[] points;
	static ArrayList<Edge> edge = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		points = new Point[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Point(i, x, y, z);
		}

		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);

			edge.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);

			edge.add(new Edge(points[i].num, points[i + 1].num, weight));
		}
		
		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);

			edge.add(new Edge(points[i].num, points[i + 1].num, weight));
		}
		
		Collections.sort(edge);
		
		int answer = 0;
		for(int i = 0; i < edge.size(); i++) {
			Edge e = edge.get(i);
			
			if(find(e.start) != find(e.end)) {
				answer += e.weight;
				union(e.start, e.end);
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
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
