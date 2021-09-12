/*
 * 13144. List of Unique Numbers
 */
package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13144 {
	static int N;
	static int A[];
	static int count[];
	static StringBuilder sb = new StringBuilder();
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N + 1];
		count = new int[100000 + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		long sum = 0;

		for (int left = 1, right = 0; left <= N; left++) {
			while (right + 1 <= N && count[A[right + 1]] == 0) {
				right++;
				count[A[right]]++;
			}

			sum += right - left + 1;

			count[A[left]]--;

		}

		sb.append(sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
		System.out.println(sb);
	}

}
