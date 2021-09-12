package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

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
			map[d - 1][s - 1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 100000;
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
		
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i != j) {
					sum += map[i][j];
				}
			}
			if (min > sum) {
				min = sum;
				ans = i + 1;
			}
			sum = 0;
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
