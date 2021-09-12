/*
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 */
package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class PRO26 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;

	static int solution(String dirs) {
		int answer = 0;

		visit = new boolean[10][10];
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = 0;
			}
		}

		bfs(dirs);

		return answer;
	}

	static void bfs(String dirs) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(4, 4));
		visit[4][4] = true;
		int cnt = 0;
		int idx = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int nx = 0, ny = 0;
			int save_x = 0, save_y = 0;
			if (dirs.charAt(idx) == 'U') {
				nx = p.x + dx[0];
				ny = p.y + dy[0];
			} else if (dirs.charAt(idx) == 'R') {
				nx = p.x + dx[1];
				ny = p.y + dy[1];
			} else if (dirs.charAt(idx) == 'D') {
				nx = p.x + dx[2];
				ny = p.y + dy[2];
			} else if (dirs.charAt(idx) == 'L') {
				nx = p.x + dx[3];
				ny = p.y + dy[3];
			}

			if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
				save_x = nx;
				save_y = ny;
				continue;
			}
			if (visit[nx][ny]) {
				continue;
			}
			visit[nx][ny] = true;

			queue.add(new Point(nx, ny));
			cnt++;
			idx++;

		}

		System.out.println(cnt);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("ULURRDLLU");
		solution("LULLLLLLU");
	}

}
