/*
 * 15565 귀여운 라이언(투포인터)
 */
package twoPointer;

import java.util.Scanner;

public class BOJ15565 {
	static int N, K;
	static int[] doll;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		doll = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			doll[i] = sc.nextInt();
		}
	}

	static void pro() {
		int right = 0;
		int sum = 0;
		int min = -1;

		for (int left = 1; left <= N; left++) {
			while (right < N && sum < K) {
				right++;
				if (doll[right] == 1)
					sum++;
			}

			if (sum == K) {
				if (min == -1)
					min = right - left + 1;
				else
					min = Math.min(min, right - left + 1);
			}
			
			if(doll[left] == 1) {
				sum--;
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
