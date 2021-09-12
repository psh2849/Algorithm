/*
 * 15970. 화살표 그리기
 */
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ15970 {
	static ArrayList<Integer>[] a;
	static int N;
	static int x, y;
	static int ans = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		a = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			a[y].add(x);
		}
	}

	static void pro() {
		for (int i = 1; i <= N; i++) {
			Collections.sort(a[i]);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < a[i].size(); j++) {
				int left = toLeft(i, j);
				int right = toRight(i, j);
				ans += Math.min(left, right);
			}
		}

		System.out.println(ans);
	}

	static int toLeft(int color, int idx) {
		if (idx == 0)
			return Integer.MAX_VALUE;
		return a[color].get(idx) - a[color].get(idx - 1);
	}

	static int toRight(int color, int idx) {
		if (idx + 1 == a[color].size())
			return Integer.MAX_VALUE;
		return a[color].get(idx + 1) - a[color].get(idx);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
