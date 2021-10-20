package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1939 {
	static class Point {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static int N, M;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Point>[] list;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		
			list[s].add(new Point(d, v));
			list[d].add(new Point(s, v));
			max = Math.max(max, v);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		binarySearch(start, dest);
	}
	
	static void binarySearch(int start, int dest) {
		int left = 1;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			queue.add(start);
			visit[start] = true;
			
			boolean isBool = bfs(mid, dest);
			
			if(isBool) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			
			queue.clear();
			Arrays.fill(visit, false);
		}
		
		System.out.println(right);
	}
	
	static boolean bfs(int mid, int dest) {
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(Point e : list[p]) {
				if(e.weight >= mid) {
					if(p == dest) {
						return true;
					}
					
					if(!visit[e.to]) {
						visit[e.to] = true;
						queue.add(e.to);
					}
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}
}
