/*
 * 2559 수열(투포인터)
 */
package twoPointer;

import java.util.Scanner;

public class BOJ2559 {
	static int N, K;
	static int[] A;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
	}

	static void pro() {
		int count = 0;
		int right = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int left = 1; left <= N; left++) {
			while (right < N && count < K) {
				right++;
				count++;
				sum += A[right];
			}
			
			if(count == K) {
				max = Math.max(max, sum);
				sum -= A[left];
				count--;
			}
			
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
