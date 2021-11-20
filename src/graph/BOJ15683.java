package graph;

import java.util.*;
import java.io.*;

public class BOJ15683 {

	static class CCTV {
		int num;
		int x;
		int y;

		CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] map;
	static int[][] copyMap;
	static int[] arr;
	static ArrayList<CCTV> list = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new CCTV(map[i][j], i, j));
				}
			}
		}

		arr = new int[list.size()];
		dfs(0, list.size());

		System.out.println(answer);
	}

	static void dfs(int depth, int r) {
		if (depth == r) {
			copyMap = new int[n][m];
			
			for(int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}

			for (int i = 0; i < list.size(); i++) {
				direction(list.get(i), arr[i]);
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (copyMap[i][j] == 0) {
						cnt++;
					}
				}
			}

			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = 0; i < 4; i++) {
			arr[depth] = i;
			dfs(depth + 1, r);
		}
	}

	static void direction(CCTV cctv, int dir) {
		int cctvNum = cctv.num;

		if (cctvNum == 1) {
			if (dir == 0)
				bfs(cctv, 0);
			else if (dir == 1)
				bfs(cctv, 1);
			else if (dir == 2)
				bfs(cctv, 2);
			else if (dir == 3)
				bfs(cctv, 3);
		} else if (cctvNum == 2) {
			if (dir == 0 || dir == 2) {
				bfs(cctv, 0);
				bfs(cctv, 2);
			} else {
				bfs(cctv, 1);
				bfs(cctv, 3);
			}
		} else if (cctvNum == 3) {
			if (dir == 0) {
				bfs(cctv, 0);
				bfs(cctv, 1);
			} else if (dir == 1) {
				bfs(cctv, 1);
				bfs(cctv, 2);
			} else if (dir == 2) {
				bfs(cctv, 2);
				bfs(cctv, 3);
			} else if (dir == 3) {
				bfs(cctv, 0);
				bfs(cctv, 3);
			}
		} else if (cctvNum == 4) {
			if (dir == 0) {
				bfs(cctv, 0);
				bfs(cctv, 1);
				bfs(cctv, 3);
			} else if (dir == 1) {
				bfs(cctv, 0);
				bfs(cctv, 1);
				bfs(cctv, 2);
			} else if (dir == 2) {
				bfs(cctv, 1);
				bfs(cctv, 2);
				bfs(cctv, 3);
			} else if (dir == 3) {
				bfs(cctv, 0);
				bfs(cctv, 2);
				bfs(cctv, 3);
			}
		} else if (cctvNum == 5) {
			bfs(cctv, 0);
			bfs(cctv, 1);
			bfs(cctv, 2);
			bfs(cctv, 3);
		}
	}

	static void bfs(CCTV cctv, int d) {
		Queue<CCTV> queue = new LinkedList<>();
		queue.add(cctv);

		while (!queue.isEmpty()) {
			CCTV p = queue.poll();

			int nx = p.x + dx[d];
			int ny = p.y + dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || copyMap[nx][ny] == 6)
				break;
			
			if (copyMap[nx][ny] == 0) {
				copyMap[nx][ny] = -1;
				queue.add(new CCTV(p.num, nx, ny));
			} else {
				queue.add(new CCTV(p.num, nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
