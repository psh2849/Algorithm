package graph;

import java.util.Scanner;

public class BOJ14503 {

	private static int n, m;
	private static int r, c, d;
	private static int cnt = 0;
	private static int[][] map;
	private static int[] dc = { 0, 1, 0, -1 };
	private static int[] dr = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		clean(r, c, d);
		
		System.out.println(cnt);
	}

	private static void clean(int row, int col, int direction) {
		// TODO Auto-generated method stub
		
		if(map[row][col] == 0) {
			map[row][col] = 2;
			cnt++;
		}
		
		boolean flag = false;
		int origin = direction;
		
		for(int i = 0; i < 4; i++) {
			int next_d = (direction + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];
			
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m) {
				if(map[next_r][next_c] == 0) {
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			direction = (direction + 3) % 4;
		}
		
		if(!flag) {
			int next_d = (origin + 2) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, origin);
				}
			}
		}
	}
}