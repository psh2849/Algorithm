/*
  2473번 세 용액
 */
package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

	static int N;
	static long[] A;
	static long min = Long.MAX_VALUE;
	static long[] save;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = new long[N + 1];
		save = new long[4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A, 1, N + 1);
	}

	static void pro() {
		int third = 2;
		int right = N;
		long sum = 0;

		for (int left = 1; left <= N; left++) {
			third = left + 1;
			right = N;
			while (third < right) {
				sum = A[left] + A[third] + A[right];
				
				if (Math.abs(sum) < Math.abs(min)) {
					save[1] = A[left];
					save[2] = A[third];
					save[3] = A[right];

					min = Math.abs(sum);
				}

				if (sum > 0) {
					right--;
				} else {
					third++;
				}
			}
		}

		Arrays.sort(save, 1, 4);
		for (int i = 1; i <= 3; i++) {
			System.out.print(save[i] + " ");
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
