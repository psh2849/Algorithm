package graph;

import java.io.*;
import java.util.*;

public class BOJ14503_2 {

	static int n, m, cnt;
	static int r, c, d;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro(r, c, d);
		
		System.out.println(cnt);
	}

	static void pro(int row, int col, int direction) {
		if (map[row][col] == 1) {
			return;
		} else if (map[row][col] == 0) {
			map[row][col] = 2;
			cnt++;
		}

		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;

			int dx = row + dir[direction][0];
			int dy = col + dir[direction][1];

			if (map[dx][dy] > 0)
				continue;
			pro(dx, dy, direction);
			return;
		}
		
		pro(row - dir[direction][0], col - dir[direction][1], direction);
		return;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
