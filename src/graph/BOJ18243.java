package graph;

import java.util.*;
import java.io.*;

public class BOJ18243 {

	static class Point {
		int to;
		int cnt;

		public Point(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
	}

	static int[][] map;
	static boolean[] visit;
	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n;  i++) {
			for(int j = 1; j <=n; j++) {
				map[i][j] = 101;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[b][a] = 1;
		}

		pro(1);
		
	}

	static void pro(int x) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 101 || map[i][j] >= 7) {
					System.out.println("Big World!");
					return;
				}
			}
		}
		
		System.out.println("Small World!");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
