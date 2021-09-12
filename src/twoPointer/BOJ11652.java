/*
 * 11652. Ä«µå
 */
package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11652 {
	static int N;
	static long mode;
	static long[] a;
	static int modeCnt = 1, curCnt = 1;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		a = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextLong();
		}
	}

	static void pro() {
		Arrays.sort(a, 1, N + 1);
		mode = a[1];

		for (int i = 2; i <= N; i++) {
			if (a[i - 1] == a[i]) {
				if(mode == a[i]) {
					modeCnt++;
				}
				curCnt++;
			} else {
				curCnt = 1;
			}

			if (modeCnt < curCnt) {
				modeCnt = curCnt;
				mode = a[i];
			}
		}
		System.out.println(mode);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
