package implementation;

import java.util.*;
import java.io.*;

public class BOJ3048 {

	static class Ant {
		char ch;
		int dir;

		public Ant(char ch, int dir) {
			this.ch = ch;
			this.dir = dir;
		}
	}

	static int n, m, time;
	static Ant[] group1;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		group1 = new Ant[n + m];
		String str1 = br.readLine();
		String str2 = br.readLine();

		for (int i = n - 1; i >= 0; i--) {
			group1[i] = new Ant(str1.charAt(n - i - 1), 1);
		}

		for (int i = n; i < n + m; i++) {
			group1[i] = new Ant(str2.charAt(i - n), 2);
		}

		int time = Integer.parseInt(br.readLine());

		while (time-- > 0) {
			for (int i = 0; i < group1.length - 1; i++) {
				if ((group1[i].dir == 1 && group1[i + 1].dir == 2)) {
					Ant ant = group1[i];
					group1[i] = group1[i + 1];
					group1[i + 1] = ant;
					i++;
				}
			}
		}

		for (int i = 0; i < group1.length; i++) {
			System.out.print(group1[i].ch);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
