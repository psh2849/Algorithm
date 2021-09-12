package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458 {

	static int N, M;
	static int[][] map;
	static int INF = 100000;
	static int ans = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[s - 1][d - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}
	}

	static void pro() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (map[i][j] == INF) {
						if (map[j][i] != INF) {
							cnt++;
						}
					} else if (map[i][j] != INF) {
						cnt++;
					}
				}
			}
			if (cnt == N - 1) {
				ans++;
			}
			cnt = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();

		System.out.println(ans);
	}

}
