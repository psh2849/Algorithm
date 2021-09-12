package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {

	static int N, M, cnt;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
	}

	static void pro() {
		int left = 0;
		int right = N - 1;

		while (left < right) {
			if (arr[left] + arr[right] == M) {
				cnt++;
				right--;
			} else if (arr[left] + arr[right] > M) {
				right--;
			} else if (arr[left] + arr[right] < M) {
				left++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
		sb.append(cnt);
		System.out.println(sb);
	}

}
