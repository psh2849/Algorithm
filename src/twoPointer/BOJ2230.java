/*
 * 2230 수고르기(투포인터)
 */
package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2230 {

	static int N, M;
	static int[] A;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A, 1, N);

	}

	static void pro() {
		int right = 1;
		int sub = 0;
		int min = Integer.MAX_VALUE;

		for (int left = 1; left <= N; left++) {
			while (right + 1 <= N && A[right] - A[left] < M) {
				++right;
			}

			if (A[right] - A[left] >= M) {
				min = Math.min(min, A[right] - A[left]);
			}

		}

		System.out.println(min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
