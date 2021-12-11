package backTracking;

import java.util.*;
import java.io.*;

public class BOJ14562 {
	static class Point {
		int s1;
		int s2;
		int count;

		public Point(int s1, int s2, int count) {
			this.s1 = s1;
			this.s2 = s2;
			this.count = count;
		}
	}

	static int c;
	static int s, t;
	static boolean[][] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());

		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			int time = pro(s, t, 0);
			System.out.println();
		}
	}

	static int pro(int start, int dest, int time) {
		if (start > dest) {
			return 100;
		}
		if (start == dest) {
			return time;
		} else {
			int min1 = pro(start * 2, dest + 3, time + 1);
			int min2 = pro(start + 1, dest, time + 1);
			
			return Math.min(min1, min2);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
