/*
 * 2003 수들의 합 2(두포인터)
 */
package topologicalSort;

import java.util.Scanner;

public class BOJ2003 {

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
	}

	static void pro() {
		int right = 0;
		int sum = 0;
		int count = 0;
		
		for(int left = 1; left <= N; left++) {
			
			while(right < N && sum < M) {
				right++;
				sum += A[right];
			}
			
			if(sum == M) {
				count++;
			}
			
			sum -= A[left];
		}
		
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
