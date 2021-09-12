/*
 * 1182. 부분수열의 합
 */
package backTracking;

import java.util.Scanner;

public class BOJ1182 {

	static int N, S;
	static int ans = 0;
	static int[] num;
	static int sum = 0;
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		num = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}

	}

	static void pro(int k, int value) {
		if(k == N + 1) {
			if(value == S) ans++;
		} else {
			pro(k + 1, value + num[k]);	
			pro(k + 1, value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro(1, 0);
		if(S==0) {
			ans--;
		}
		System.out.println(ans);
	}

}
