package graph;

import java.util.*;
import java.io.*;

public class BOJ2210 {
	static String str = "";
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static HashSet<String> set = new HashSet<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, str);
			}
		}
		
		System.out.println(set.size());
	}

	static void dfs(int x, int y, int cnt, String s) {
		if (cnt == 6) {
			set.add(s);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5)
				continue;
			dfs(dx, dy, cnt + 1, s + map[dx][dy]);

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
