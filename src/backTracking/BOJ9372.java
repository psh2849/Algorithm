package backTracking;

import java.util.Scanner;

public class BOJ9372 {
	static int T;
	static int N, M;
	static int[] dist;
	static int[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			M = sc.nextInt();

			for (int i = 1; i <= M; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
			}
			
			System.out.println(N-1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
