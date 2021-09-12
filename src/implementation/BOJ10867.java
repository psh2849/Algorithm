package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10867 {
	static int N, cnt = 0;
	static int[] arr;
	static boolean[] num;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		num = new boolean[2002];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] != arr[i]) {
				System.out.print(arr[i - 1] + " ");
			}
		}
		System.out.println(arr[N-1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
