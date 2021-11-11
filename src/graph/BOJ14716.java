package graph;

import java.util.*;
import java.io.*;

public class BOJ14716 {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
			if(visit[dx][dy]) continue;
			if(map[dx][dy] == 0) continue;
			dfs(dx, dy);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
