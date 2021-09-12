package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
	static int N, M, x, y, K;
	static int[] dice;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dice = new int[7];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro(int x, int y) throws IOException {
		int command;
		st = new StringTokenizer(br.readLine(), " ");

		for (int k = 0; k < K; k++) {
			command = Integer.parseInt(st.nextToken());
			int dx = x + dir[command - 1][0];
			int dy = y + dir[command - 1][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			moveDice(command);

			if (map[dx][dy] == 0) {
				map[dx][dy] = dice[6];
			} else {
				dice[6] = map[dx][dy];
				map[dx][dy] = 0;
			}

			x = dx;
			y = dy;

			sb.append(dice[1] + "\n");
		}
	}

	static void moveDice(int command) {
		if (command == 1) {
			int temp = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = temp;
		} else if (command == 2) {
			int temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = temp;
		} else if (command == 3) {
			int temp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = temp;
		} else if (command == 4) {
			int temp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro(x, y);
		System.out.println(sb);
	}
}
