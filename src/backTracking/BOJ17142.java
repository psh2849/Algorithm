package backTracking;

import java.util.*;
import java.io.*;

public class BOJ17142 {

	static class Virus {
		int x;
		int y;
		int time;

		public Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int min = Integer.MAX_VALUE;
	static int empty;
	static int n, m;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static List<Virus> virus = new ArrayList<>();
	static Virus[] select;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		select = new Virus[m];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					empty++;
				}
				if (map[i][j] == 2) {
					virus.add(new Virus(i, j, 0));
				}
			}
		}

		if (empty == 0) {
			System.out.println(0);
			return;
		} else {
			find(0, 0);
			if(min == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(min);
		}

	}

	static void find(int start, int count) {
		if (count == m) {
			bfs();
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			select[count] = virus.get(i);
			find(i + 1, count + 1);
		}
	}

	static void bfs() {
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		int emptySize = empty;
		
		for (int i = 0; i < m; i++) {
			queue.add(select[i]);
			visit[select[i].x][select[i].y] = true;
		}

		while (!queue.isEmpty()) {
			Virus v = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = v.x + dir[i][0];
				int dy = v.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n || visit[dx][dy] || map[dx][dy] == 1)
					continue;
				if (map[dx][dy] == 0) {
					emptySize--;
				} 
				
				if (emptySize == 0) {
					min = Math.min(min, v.time + 1);
					return;
				}
				
				queue.add(new Virus(dx, dy, v.time + 1));
				visit[dx][dy] = true;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
