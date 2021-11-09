package graph;

import java.util.*;
import java.io.*;

public class BOJ2660 {

	static int n;
	static int[][] map;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 51;
			}
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1) {
				break;
			}

			map[a][b] = 1;
			map[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		int[] rank = new int[n + 1];
		int min = 51;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				max = Math.max(max, map[i][j]);
			}
			rank[i] = max;
			min = Math.min(min, max);
		}

		int cnt = 0;
		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (rank[i] == min) {
				ans[cnt] = i;
				cnt++;

			}
		}

		System.out.println(min + " " + cnt);
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == 0)
				continue;
			System.out.print(ans[i] + " ");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
