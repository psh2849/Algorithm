/*
 * 3273 두수의 합
 */
package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3273 {

	static int N;
	static int x;
	static int ans = 0;
	static int[] arr;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		x = sc.nextInt();
		Arrays.sort(arr);
	}

	static void pro() {
		int left = 1;
		int right = N;
		
		if(N == 1) {
			int sum = arr[left];
			if(sum == x) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			return;
		}
		
		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == x) {
				ans++;
			}
			
			if(sum > x) right--;
			else left++;
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
