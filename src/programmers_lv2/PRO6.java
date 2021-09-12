/*
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 */
package programmers_lv2;

import java.util.Queue;

import java.util.LinkedList;

public class PRO6 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int solution(int[][] maps) {
		int answer = 0;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int[][] dist = new int[maps.length][maps[0].length];
		boolean[][] visit = new boolean[maps.length][maps[0].length];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		dist[0][0] = 1;
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= maps.length || dy >= maps[0].length)
					continue;
				if (visit[dx][dy])
					continue;
				if (maps[dx][dy] == 0)
					continue;

				queue.add(new Point(dx, dy));
				visit[dx][dy] = true;
				dist[dx][dy] = dist[p.x][p.y] + 1;
			}
		}
		
		answer = dist[maps.length - 1][maps[0].length - 1];
		if(answer == 0) {
			answer = -1;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		solution(maps);
	}

}
