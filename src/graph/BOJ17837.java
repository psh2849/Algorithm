package graph;

import java.util.*;
import java.io.*;

public class BOJ17837 {

	static class Horse {
		int num;
		int x;
		int y;
		int dir;

		public Horse(int num, int x, int y, int dir) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public void changeDirection() {
			if (dir == 0) {
				dir = 1;
			} else if (dir == 1) {
				dir = 0;
			} else if (dir == 2) {
				dir = 3;
			} else if (dir == 3) {
				dir = 2;
			}
		}
	}

	static int n, k;
	static ArrayList<Integer>[][] board;
	static Horse[] horse;
	static int[][] color;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		horse = new Horse[k];
		board = new ArrayList[n][n];
		color = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = new ArrayList<>();
			}
		}
	
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			horse[i] = new Horse(i, a - 1, b - 1, d - 1);
			board[a - 1][b - 1].add(i);
		}

		pro();
	}

	static void pro() {
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < k; j++) {
				if (move(j)) {
					System.out.println(i);
					return;
				}
			}
		}

		System.out.println(-1);
	}

	static boolean move(int idx) {
		Horse h = horse[idx];
		int nx = h.x + dx[h.dir];
		int ny = h.y + dy[h.dir];
		
		if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || color[nx][ny] == 2) {
			h.changeDirection();
			nx = h.x + dx[h.dir];
			ny = h.y + dy[h.dir];
		}
		
		if ((nx >= 0 && ny >= 0 && nx < n && ny < n) && color[nx][ny] == 0) {
			ArrayList<Integer> to = board[nx][ny];
			ArrayList<Integer> from = board[h.x][h.y];
			
			int index = from.indexOf(h.num);
			int size = from.size();
			
			for (int i = index; i < size; i++) {
				int remove = from.remove(index);
				horse[remove].x = nx;
				horse[remove].y = ny;
				to.add(remove);
			}
			
			if (board[nx][ny].size() >= 4) {
				return true;
			}
		}

		if ((nx >= 0 && ny >= 0 && nx < n && ny < n) && color[nx][ny] == 1) {
			ArrayList<Integer> to = board[nx][ny];
			ArrayList<Integer> from = board[h.x][h.y];
			
			int index = from.indexOf(h.num);
			int size = from.size();
			
			for (int i = index; i < size; i++) {
				int remove = board[h.x][h.y].remove(board[h.x][h.y].size() - 1);
				horse[remove].x = nx;
				horse[remove].y = ny;
				to.add(remove);
			}
			
			if (board[nx][ny].size() >= 4) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}
