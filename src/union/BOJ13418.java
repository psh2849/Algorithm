package union;

import java.util.*;
import java.io.*;

public class BOJ13418 {

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

	static int n, m;
	static ArrayList<Point> list = new ArrayList<>();
	static int[] parent;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()) + 1;
		m = Integer.parseInt(st.nextToken()) + 1;

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Point(to, from, weight));
		}
		
		Collections.sort(list);
		pro();
		
	}

	static void pro() {
		int min = 0;
		int max = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			
			if(find(p.from) != find(p.to)) {
				if(p.weight == 0) {
					min++;
				}
				union(p.from, p.to);
			}
		}
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = list.size() - 1; i >= 0; i--) {
			Point p = list.get(i);
			
			if(find(p.from) != find(p.to)) {
				if(p.weight == 0) {
					max++;
				}
				
				union(p.from, p.to);
			}
		}
		System.out.println((int)(Math.pow(min, 2) - Math.pow(max, 2)));
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
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
