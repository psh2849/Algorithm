package graph;

import java.util.*;
import java.io.*;

public class BOJ11060 {

	static class Point {
		int idx;
		int cnt;

		public Point(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static int n;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		pro(1);
	}

	static void pro(int start) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start, 0));
		boolean[] visit = new boolean[n + 1];
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.idx == n) {
				System.out.println(p.cnt);
				return;
			}

			for (int i = 1; i <= arr[p.idx]; i++) {
				int dx = p.idx + i;
				
				if(dx > n) break;
				if(visit[dx]) continue;
				visit[dx] = true;
				queue.add(new Point(dx, p.cnt + 1));
			}
		}
		
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
