package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {

	static int R, C, cnt = 1;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visit = new boolean[27];
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 1);
	}

	static void dfs(int x, int y, int count) {
		int num = map[x][y];
		visit[num] = true;
		
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
			if(visit[map[dx][dy]]) continue;
			
			dfs(dx, dy, count + 1);
		}
		visit[map[x][y]] = false;
		max = Math.max(max, count);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		System.out.println(max);
	}
}
