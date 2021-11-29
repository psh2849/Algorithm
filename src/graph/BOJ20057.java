package graph;

import java.util.*;
import java.io.*;

public class BOJ20057 {

	static int n;
	static int now_x, now_y;
	static int cnt = 0, move_cnt = 1, dir = 0, answer = 0;
	static int[][] dx = { { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 }, { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 },
			{ -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 }, { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } };
	static int[][] dy = { { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 },
			{ -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } };
	static int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		now_x = n / 2 + 1;
		now_y = n / 2 + 1;

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (cnt == 2) {
				cnt = 0;
				move_cnt++;
			}

			for (int i = 0; i < move_cnt; i++) {
				move(dir);
				spread();
				if(now_x == 1 && now_y == 1) {
					System.out.println(answer);
					return;
				}
			}
			
			if(dir == 3) {
				dir = 0;
			} else {
				dir++;
			}
			
			cnt++;
		}

	}

	static void move(int dir) {
		if (dir == 0) {
			now_y--;
		} else if (dir == 1) {
			now_x++;
		} else if (dir == 2) {
			now_y++;
		} else if (dir == 3) {
			now_x--;
		}
	}

	static void spread() {
		int total = map[now_x][now_y];
		int temp = total;
		
		int nx, ny;
		for (int i = 0; i < 9; i++) {
			nx = now_x + dx[dir][i];
			ny = now_y + dy[dir][i];
			int sand = total * percent[i] / 100;

			temp -= sand;
			if (nx < 1 || ny < 1 || nx > n || ny > n) {
				answer += sand;
				continue;
			} else {
				map[nx][ny] += sand;
			}
		}
		
		nx = now_x + dx[dir][9];
		ny = now_y + dy[dir][9];
		
		if(nx < 1 || ny < 1 || nx > n || ny > n) {
			answer += temp;
		} else {
			map[nx][ny] += temp;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
