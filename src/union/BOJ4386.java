package union;

import java.util.*;
import java.io.*;

public class BOJ4386 {
	static class Point {
		double x;
		double y;
		int num;

		public Point(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			if(weight < o.weight) {
				return -1;
			} 
			
			return 1;
		}
	}

	static int n;
	static int[] parent;
	static ArrayList<Edge> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		Point[] point = new Point[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());

			point[i] = new Point(i, a, b);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double value = distance(point[i], point[j]);
				list.add(new Edge(point[i].num, point[j].num, value));
			}
		}
		
		System.out.println(kruskal());
	}

	static double distance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	static double kruskal() {
		double answer = 0;
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) { 
			Edge e = list.get(i);
			
			if(find(e.end) != find(e.start)) {
				answer += e.weight;
				union(e.end, e.start);
			}
		}
		
		return answer;
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
