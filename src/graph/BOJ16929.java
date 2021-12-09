package graph;

import java.util.*;
import java.io.*;

public class BOJ16929 {

	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					boolean answer = pro(i, j, -1, -1, map[i][j]);
					if(answer) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		
		System.out.println("No");
	}

	static boolean pro(int x, int y, int nx, int ny, int origin) {
		if(visit[x][y]) return true;
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++ ) { 
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
			if(map[dx][dy] != origin) continue;
			if(dx == nx && dy == ny) continue;
			
			if(pro(dx, dy, x, y, origin)) return true;
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
