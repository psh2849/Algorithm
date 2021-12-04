package graph;

import java.util.*;
import java.io.*;

public class BOJ20058 {

	static int n, m, q, num = 1, max = 0;
	static int[][] map, copy;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		num = (int) Math.pow(2, n);
		map = new int[num][num];
		visit = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < q; i++) {
			int level = Integer.parseInt(st.nextToken());
			map = rotate(level);
			map = melt();
		}
	
		int answer = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				answer += map[i][j];
				if (map[i][j] > 0 && !visit[i][j]) {
					find(i, j);
				}
			}
		}

		System.out.println(answer);
		System.out.println(max);
	}

	static int[][] rotate(int level) {
		copy = new int[num][num];
		int len = (int) Math.pow(2, level);

		for (int i = 0; i < num; i += len) {
			for (int j = 0; j < num; j += len) {
				for (int a = 0; a < len; a++) {
					for (int b = 0; b < len; b++) {
						copy[i + b][j + len - a - 1] = map[i + a][j + b];
					}
				}
			}
		}

		return copy;
	}

	static int[][] melt() {
		copy = new int[num][num];
		
		for(int i = 0; i < num; i++) {
			copy[i] = Arrays.copyOf(map[i], num);
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int cnt = 0;

				if (map[i][j] == 0)
					continue;

				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || ny < 0 || nx >= num || ny >= num)
						continue;
					if (map[nx][ny] > 0) {
						cnt++;
					}
				}

				if (cnt < 3)
					copy[i][j]--;
			}
		}
		
		return copy;
	}

	static void find(int tx, int ty) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { tx, ty });
		visit[tx][ty] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= num || ny >= num)
					continue;
				
				if(visit[nx][ny]) continue;
				
				if (map[nx][ny] > 0) {
					cnt++;
					visit[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}
		}

		max = Math.max(max, cnt);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
