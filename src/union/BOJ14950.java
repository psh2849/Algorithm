package union;

import java.util.*;
import java.io.*;

public class BOJ14950 {

	static class Point implements Comparable<Point> {
		int to;
		int from;
		int weight;

		public Point(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}

	static int n, m, t;
	static ArrayList<Point> list = new ArrayList<>();
	static int[] parent;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Point(to, from, weight));
		}
		
		Collections.sort(list);
		pro();
		
	}
	
	static void pro() {
		int result = 0;
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			
			if(find(p.to) != find(p.from)) {
				union(p.to, p.from);
				
				result += p.weight + sum;
				sum += t;
			}
		}
		
		System.out.println(result);
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
