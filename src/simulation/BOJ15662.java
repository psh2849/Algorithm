package simulation;

import java.util.*;
import java.io.*;

public class BOJ15662 {

	static int n, t;
	static int[][] arr;
	static boolean[] check;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][8];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			check = new boolean[n];
			check();
			rotate(k, d);
		}

		result();
	}

	static void check() {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i][2] != arr[i + 1][6]) {
				check[i] = true;
			}
		}
	}

	static void rotate(int num, int d) {
		turn(num, d);

		if (n > 1) {
			boolean[] turn = new boolean[n];
			turn[num] = true;

			int ldir = d * -1;
			for (int i = num - 1; i >= 0; i--) {
				if (check[i] && turn[i + 1]) {
					turn[i] = true;
					turn(i, ldir);
					ldir *= -1;
				}
			}

			int rdir = d * -1;
			for (int i = num + 1; i < n; i++) {
				if (check[i - 1] && turn[i - 1]) {
					turn[i] = true;
					turn(i, rdir);
					rdir *= -1;
				}
			}
		}
	}

	static void turn(int num, int d) {
		if (d == 1) {
			int temp = arr[num][7];
			for (int i = 7; i > 0; i--) {
				arr[num][i] = arr[num][i - 1];
			}

			arr[num][0] = temp;
		} else {
			int temp = arr[num][0];
			for (int i = 0; i < 7; i++) {
				arr[num][i] = arr[num][i + 1];
			}

			arr[num][7] = temp;
		}
	}

	static void result() {
		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer += arr[i][0];
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
