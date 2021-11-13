package union;

import java.util.*;
import java.io.*;

public class BOJ16398 {

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

	static int n;
	static int[] parent;
	static int[][] map;
	static ArrayList<Point> list = new ArrayList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				list.add(new Point(i, j, value));
			}
		}
		
		Collections.sort(list);
		System.out.println(kruskal());
	}

	static long kruskal() {
		long result = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			
			if(find(p.from) != find(p.to)) {
				result += p.weight;
				union(p.from, p.to);
			}
		}
		
		return result;
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) { 
			parent[b] = a;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
