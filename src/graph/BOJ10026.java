package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
	static int N;
	static char[][] map;
	static char[][] copyMap;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int cnt = 0;
	static int colorCnt = 0;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N][N];
		map = new char[N][N];
		copyMap = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j];
				if(str[j] == 'G') {
					copyMap[i][j] = 'R';
				} else {
					copyMap[i][j] = str[j];
				}
			}
		}
	}

	static void pro(int x, int y, char ch, char[][] arr) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
			if(visit[dx][dy]) continue;
			
			if(arr[dx][dy] == ch) {
				pro(dx, dy, ch, arr);
			}
		}
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					cnt++;
					pro(i, j, map[i][j], map);
				}
			}
		}
		
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					colorCnt++;
					pro(i, j, copyMap[i][j], copyMap);
				}
			}
		}
		
		System.out.println(cnt + " " + colorCnt);
	}

}
