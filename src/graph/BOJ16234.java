package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visit;
	static ArrayList<Point> list;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visit = new boolean[N][N];
		list = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = pro();
		System.out.println(ans);
	}

	static int pro() {
		int day = 0;
		boolean isMove;

		while (true) {
			visit = new boolean[N][N];
			isMove = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					if (open(i, j))
						isMove = true;
				}
			}

			if (isMove)
				day++;
			else
				return day;
		}
	}

	static boolean open(int x, int y) {
		queue.clear();
		list.clear();

		queue.add(new Point(x, y));
		list.add(new Point(x, y));
		visit[x][y] = true;
		int sum = map[x][y];

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (visit[dx][dy])
					continue;

				int sub = Math.abs(map[dx][dy] - map[p.x][p.y]);
				if (sub < L || sub > R)
					continue;

				sum += map[dx][dy];
				queue.add(new Point(dx, dy));
				list.add(new Point(dx, dy));
				visit[dx][dy] = true;
			}
		}
		
		if(list.size() == 1) return false;
		else {
			int temp = sum / list.size();
		
			for(Point p : list) {
				map[p.x][p.y] = temp; 
			}
			
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
