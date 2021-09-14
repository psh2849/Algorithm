package backTracking;

import java.util.Scanner;

public class BOJ10974 {
	static int N;
	static boolean[] visit;
	static int[] arr, output;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		visit = new boolean[N + 1];
		arr = new int[N + 1];
		output = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		pro(1);

	}

	static void pro(int k) {
		if (k == N + 1) {
			for (int i = 1; i <= N; i++) {
				if(visit[i]) {
					System.out.print(output[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				output[k] = arr[i];
				pro(k + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
