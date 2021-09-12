package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ17140 {
	static class Point implements Comparable<Point> {
		int num;
		int cnt;

		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (cnt < o.cnt) {
				return -1;
			} else if (cnt == o.cnt) {
				if (num >= o.num) {
					return 1;
				} else if (num < o.num) {
					return -1;
				}
			} else {
				return 1;
			}

			return 0;
		}

	}

	static int row_cnt = 3;
	static int col_cnt = 3;
	static int r, c, k;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[101][101];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro();
	}

	static void pro() {
		int time = 0;

		while (true) {
			if (map[r][c] == k) {
				break;
			}
			if (time == 101) {
				time = -1;
				break;
			}
			if (row_cnt <= col_cnt) {
				rowSort();
			} else {
				colSort();
			}
			time++;

		}

		System.out.println(time);
	}

	static void rowSort() {
		int[] count = new int[101];
		ArrayList<Point> list = new ArrayList<>();
		int tempRow = 0;
		for (int i = 1; i <= col_cnt; i++) {
			for (int j = 1; j <= row_cnt; j++) {
				count[map[i][j]]++;
				map[i][j] = 0;
			}

			for (int j = 1; j < count.length; j++) {
				if (count[j] != 0) {
					list.add(new Point(j, count[j]));
				}
			}

			Collections.sort(list);

			int idx = 1;
			for (Point p : list) {
				map[i][idx++] = p.num;
				map[i][idx++] = p.cnt;
			}
			if (tempRow <= idx)
				tempRow = idx;

			list.clear();
			count = new int[101];
		}

		row_cnt = tempRow;
	}

	static void colSort() {
		int[] count = new int[101];
		ArrayList<Point> list = new ArrayList<>();
		int tempCol = 0;

		for (int i = 1; i <= row_cnt; i++) {
			for (int j = 1; j <= col_cnt; j++) {
				count[map[j][i]]++;
				map[j][i] = 0;
			}

			for (int j = 1; j < count.length; j++) {
				if (count[j] != 0) {
					list.add(new Point(j, count[j]));
				}
			}

			Collections.sort(list);

			int idx = 1;
			for (Point p : list) {
				map[idx++][i] = p.num;
				map[idx++][i] = p.cnt;
			}

			if (tempCol <= idx) {
				tempCol = idx;
			}

			list.clear();
			count = new int[101];
		}

		col_cnt = tempCol;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
