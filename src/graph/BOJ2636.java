package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1 {
	int x;
	int y;

	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ2636 {

	static int[][] map;
	static boolean[][] visit;
	static int N, M;
	static int cheeseCount = 0;
	static int cheese = 0;
	static int cnt;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					cheeseCount++;
				}
			}
		}

		int time = 0;
		while (cheeseCount != 0) {
			time++;
			cnt = cheeseCount;
			melting();
		}

		System.out.println(time);
		System.out.println(cnt);
	}

	static void melting() {
		Queue<Point1> queue = new LinkedList<Point1>();
		queue.add(new Point1(0, 0));
		visit = new boolean[N][M];
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Point1 point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = point.x + dir[i][0];
				int dy = point.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (map[dx][dy] == 1 && !visit[dx][dy]) {
					cheeseCount--;
					map[dx][dy] = 0;
				} else if (map[dx][dy] == 0 && !visit[dx][dy]) {
					queue.add(new Point1(dx, dy));
				}
				visit[dx][dy] = true;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
