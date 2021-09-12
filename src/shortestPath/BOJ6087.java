package shortestPath;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6087 {
	static class Point {
		int x;
		int y;
		int dir;
		int count;

		public Point(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
	}

	static int H, W, answer = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dist;
	static int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static ArrayList<Point> laser = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		dist = new int[H][W];

		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				dist[i][j] = Integer.MAX_VALUE;
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C') {
					laser.add(new Point(i, j, -1, 0));
				}
			}
		}
		
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();

		Point start = laser.get(0);
		Point dest = laser.get(1);

		queue.add(start);
		dist[start.x][start.y] = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int count = p.count;
			int dir = p.dir;
			
			if(x == dest.x && y == dest.y) {
				answer = Math.min(answer, count);
			}
			for (int i = 0; i < 4; i++) {
				int dx = x + direction[i][0];
				int dy = y + direction[i][1];
				int dd = i;

				if (dx < 0 || dy < 0 || dx >= H || dy >= W)
					continue;
				if (map[dx][dy] == '*')
					continue;

				int temp = count;
				if (dir != dd && dir != -1) {
					temp++;
				}
				if (dist[dx][dy] < temp) {
					continue;
				}

				dist[dx][dy] = temp;
				queue.add(new Point(dx, dy, dd, temp));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}
}
