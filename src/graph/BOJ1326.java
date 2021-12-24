package graph;

import java.util.*;
import java.io.*;

public class BOJ1326 {

	static class Point {
		int x;
		int time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static int n, a, b;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		pro();
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];

		queue.add(new Point(a, 0));
		visit[a] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == b) {
				System.out.println(p.time);
				return;
			}
			int num = arr[p.x];

			for (int i = 1; p.x + (num * i) <= n; i++) {
				int next = p.x + num * i;
				
				if (!visit[next]) {
					queue.add(new Point(next, p.time + 1));
					visit[next] = true;
				}
			}

			for (int i = 1; p.x - (num * i) >= 1; i++) {
				int next = p.x - num * i;
				
				if(!visit[next]) {
					queue.add(new Point(next, p.time + 1));
					visit[next] = true;
				}
			}
		}
		
		System.out.println("-1");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
