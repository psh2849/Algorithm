package backTracking;

import java.util.*;
import java.io.*;

public class BOJ15684 {

	static int n, m, h;
	static int answer = 4;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[a][b + 1] = 2;
		}
		
		dfs(1, 0);
		if(answer != 4) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
	
	static void dfs(int start, int count) { 
		if(answer <= count) {
			return;
		} else {
			if(check()) {
				answer = count;
				return;
			}
		}
		
		for(int i = start; i <= h; i++) {
			for(int j = 1; j < n; j++) {
				if(map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(i, count + 1);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}
			}
		}
	}

	static boolean check() {
		for(int i = 1; i <= n; i++) {
			int x = 1;
			int y = i;
			for(int j = 0; j < h; j++) {
				if(map[x][y] == 1) {
					y++;
				} 
				else if(map[x][y] == 2) {
					y--;
				}
				x++;
			}
			if(y != i) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
