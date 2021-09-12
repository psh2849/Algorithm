/*
 * 10815. 숫자 카드
 */
package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
	static int N;
	static int M;
	static int[] my_card;
	static StringBuilder sb = new StringBuilder();
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		my_card = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			my_card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(my_card, 1, N + 1);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int save = search(num);
			sb.append(save + " ");
		}

	}

	static int search(int search_num) {
		int left = 1;
		int right = N;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (my_card[mid] == search_num)
				return 1;
			else if (my_card[mid] > search_num)
				right = mid - 1;
			else
				left = mid + 1;

		}

		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		System.out.println(sb);
	}

}