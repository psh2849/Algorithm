/*
 * 13702. 이상한 술집
 */
package binarySearch;

import java.util.Scanner;

public class BOJ13702 {

	static int N, K;
	static int[] kettle;
	static int ans = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		kettle = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			kettle[i] = sc.nextInt();
		}
	}

	static void pro() {
		long left = 1;
		long right = Integer.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (search(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}

	static boolean search(long mid) {
		int possible = 0;
	
		for (int i = 1; i <= N; i++) {
			possible += kettle[i] / mid;
			if (possible >= K) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
