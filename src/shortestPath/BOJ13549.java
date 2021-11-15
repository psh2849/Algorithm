package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ13549 {
	static class Point {
		int x;
		int time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static int min = Integer.MAX_VALUE;
	static int n, k;
	static boolean[] visit;
	static int max = 100000;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		
		pro();
		
		System.out.println(min);
	}
	
	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, 0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			visit[p.x] = true; 
			if(p.x == k) {
				min = Math.min(min, p.time);
			}
			if(p.x * 2 <= max && !visit[p.x * 2]) queue.add(new Point(p.x * 2, p.time));
			if(p.x + 1 <= max && !visit[p.x + 1]) queue.add(new Point(p.x + 1, p.time + 1));
			if(p.x - 1 > 0 && !visit[p.x - 1]) queue.add(new Point(p.x - 1, p.time + 1));
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
