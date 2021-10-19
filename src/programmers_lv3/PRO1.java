/*
 * https://programmers.co.kr/learn/courses/30/lessons/67259
 */
package programmers_lv3;

import java.util.PriorityQueue;

public class PRO1 {
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int dir;
		int cost;

		public Point(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	static boolean[][] visit;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int min = Integer.MAX_VALUE;

	static int solution(int[][] board) {
		visit = new boolean[board.length][board[0].length];
		map = new int[board.length][board[0].length];
		map = board.clone();

		bfs(0, 0);
		System.out.println(min);
		return min;
	}

	static void bfs(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		int[][][] check = new int[map.length][map[0].length][4];
		for (int i = 0; i < 4; i++) {
			check[x][y][i] = -1;
		}
		if (map[x][y + 1] == 0) {
			queue.add(new Point(x, y + 1, 0, 100));
			check[x][y + 1][0] = 100;
		} 
		if (map[x + 1][y] == 0) {
			queue.add(new Point(x + 1, y, 1, 100));
			check[x + 1][y][1] = 100;
		}
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == map.length - 1 && p.y == map[0].length - 1) {
				min = p.cost;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				int s = p.cost + (i == p.dir ? 100 : 600);
				
				if (dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length || map[dx][dy] == 1)
					continue;
			
				if(check[dx][dy][i] != 0 && check[dx][dy][i] <= s) continue;
				queue.add(new Point(dx, dy, i, s));
				check[dx][dy][i] = s;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };

		solution(board);
	}

}
