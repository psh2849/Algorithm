package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1744 {
	static int N;
	static int[] arr;
	static int minusCnt = 0, plusCnt = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] <= 0) {
				minusCnt++;
			} else {
				plusCnt++;
			}
		}
	}

	static void pro() {
		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] <= 0) {
				if (i == N - 1) {
					sum += arr[i];
				} else if (arr[i + 1] <= 0) {
					sum += arr[i] * arr[i + 1];
					i++;
				} else {
					sum += arr[i];
				}
			} else {
				break;
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if(arr[i] > 0) {
				if (i == 0) {
					sum += arr[i];
				} else if (arr[i - 1] > 1) {
					sum += arr[i] * arr[i - 1];
					i--;
				} else {
					sum += arr[i];
				}
			}
		}

		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
