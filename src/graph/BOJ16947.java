package graph;

import java.util.*;
import java.io.*;

public class BOJ16947 {
	static class Point {
		int num;
		int cnt;
		
		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			if(dfs(i, i, i)) break;
		}
		
		for(int i = 1; i <= n; i++) {
			bfs(i);
		}
	}
	
	static boolean dfs(int prev, int now, int start) {
		visit[now] = true;
		
		for(int next : list[now]) {
			if(!visit[next]) {
				if(dfs(now, next, start)) return true;
			} else {
				if(next != prev && next == start) return true;
			}
		}
		
		visit[now] = false;
		return false;
	}
	
	static void bfs(int start) {
		Queue<Point> queue = new LinkedList<>();
		boolean[] v = new boolean[n + 1];
		queue.add(new Point(start, 0));
		v[start] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(visit[p.num]) {
				System.out.print(p.cnt + " "); 
				return;
			}
			
			for(int num : list[p.num]) {
				if(!v[num]) {
					queue.add(new Point(num, p.cnt + 1));
					v[num] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
