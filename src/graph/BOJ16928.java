package graph;

import java.util.*;
import java.io.*;

public class BOJ16928 {

	static class Point {
		int idx;
		int cnt;

		public Point(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static int n, m;
	static int[] map = new int[101];
	static int[] ladder = new int[101];
	static int[] snake = new int[101];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladder[a] = b;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			snake[a] = b;
		}

		pro(1);
	}

	static void pro(int start) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start, 0));
		boolean[] visit = new boolean[101];
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
		
			if (p.idx == 100) {
				System.out.println(p.cnt);
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				int index = p.idx + i;

				if (index > 100)
					break;
				
				if (ladder[index] != 0 && !visit[index]) {
					visit[index] = true;
					queue.add(new Point(ladder[index], p.cnt + 1));
				} else if (snake[index] != 0 && !visit[index]) {
					visit[index] = true;
					queue.add(new Point(snake[index], p.cnt + 1));
				} else if(!visit[index]){
					visit[index] = true;
					queue.add(new Point(index, p.cnt + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
