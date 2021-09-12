/*
 * 18404. 현명한 나이트
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ18404 {
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };
	static int N, M;
	static int enemy_x, enemy_y;
	static int[][] enemy;
	static int[][] knight;
	static int[][] dist;
	static boolean[][] visit;
	static int[][] map;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		visit = new boolean[N][N];
		dist = new int[N][N];
		knight = new int[N][N];
		enemy = new int[N][N];

		int kx = sc.nextInt();
		int ky = sc.nextInt();
		knight[kx - 1][ky - 1] = 1;
		pro(kx - 1, ky - 1);
		
		for (int i = 0; i < M; i++) {
			enemy_x = sc.nextInt();
			enemy_y = sc.nextInt();
			System.out.print(dist[enemy_x-1][enemy_y-1] + " ");
		}
	}

	static void pro(int x, int y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = 0;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		queue.add(y);
		dist[x][y] = 0;
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			x = queue.poll();
			y = queue.poll();

			for (int i = 0; i < 8; i++) {
				int dx = x + dir[i][0];
				int dy = y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;

				if (!visit[dx][dy]) {
					queue.add(dx);
					queue.add(dy);
					visit[dx][dy] = true;
					dist[dx][dy] = dist[x][y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
