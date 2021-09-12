/*
 * 2638¹ø. Ä¡Áî
 */
package graph;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ2638 {
	static int N, M, time = 0;
	static int cheeseCount = 0;
	static ArrayList<Point> cheeseLocationList = new ArrayList<>();
	static boolean[][] visit;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					cheeseCount++;
					cheeseLocationList.add(new Point(i, j));
				}
			}
		}

		while (cheeseCount != 0) {
			visit = new boolean[N][M];
			time++;
			externalAirDfs(0, 0);
			cheeseMeltingDfs();

		}

		System.out.println(time);
	}

	static void externalAirDfs(int x, int y) {
		visit[x][y] = true;
		map[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			if (visit[dx][dy] || map[dx][dy] == 1)
				continue;

			externalAirDfs(dx, dy);
		}
	}

	static void cheeseMeltingDfs() {
		for (int i = 0; i < cheeseLocationList.size(); i++) {
			int x = cheeseLocationList.get(i).x;
			int y = cheeseLocationList.get(i).y;
			int cnt = 0;

			for (int j = 0; j < 4; j++) {
				int dx = x + dir[j][0];
				int dy = y + dir[j][1];
				
				if(map[dx][dy] == 2) {
					cnt++;
				}
			}
			
			if(cnt >= 2) {
				cheeseCount--;
				map[x][y] = 0;
				cheeseLocationList.remove(i);
				i--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
