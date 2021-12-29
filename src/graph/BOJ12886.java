package graph;

import java.util.*;
import java.io.*;

public class BOJ12886 {

	static class Stone {
		int a;
		int b;
		int c;

		public Stone(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static int a, b, c, ans;
	static boolean[][] visit;
	static HashMap<Stone, Boolean> map = new HashMap<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		if ((a + b + c) % 3 != 0) {
			System.out.println(0);
			return;
		}

		visit = new boolean[1501][1501];
		pro(a, b, c);
		System.out.println(ans);
	}

	static void pro(int a, int b, int c) {
		if (a == b && b == c) {
			ans = 1;
			return;
		}

		calc(a, b, c);
		calc(b, c, a);
		calc(a, c, b);
	}

	static void calc(int a, int b, int fix) {
		int small = Math.min(a, b);
		int big = Math.max(a, b);

		if (!visit[small * 2][big - small]) {
			visit[small * 2][big - small] = true;
			visit[big - small][small * 2] = true;
			pro(small * 2, big - small, fix);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
