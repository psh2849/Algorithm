/*
 * 1261. ¾Ë°í½ºÆÌ
 */
package shortestPath;

import java.util.PriorityQueue;
import java.util.Scanner;

class Position implements Comparable<Position> {
	int x;
	int y;
	int cnt;

	public Position(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Position o) {
		// TODO Auto-generated method stub
		return cnt - o.cnt;
	}

}

public class BOJ1261 {
	static int N, M;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] dist;
	static boolean[][] visit;
	static int[][] map;
	static int count = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		dist = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String input = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j - 1));
			}
		}

		pro(1, 1);
	}

	static void pro(int x, int y) {
		PriorityQueue<Position> queue = new PriorityQueue<>();
		queue.add(new Position(x, y, 0));

		while (!queue.isEmpty()) {
			Position p = queue.poll();
			if (p.x == N && p.y == M) {
				System.out.println(p.cnt);
			}

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 1 || dy < 1 || dx > N || dy > M) {
					continue;
				}

				if (map[dx][dy] == 0 && !visit[dx][dy]) {
					queue.add(new Position(dx, dy, p.cnt));
					visit[dx][dy] = true;
				}

				else if (map[dx][dy] == 1 && !visit[dx][dy]) {
					queue.add(new Position(dx, dy, p.cnt + 1));
					visit[dx][dy] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
