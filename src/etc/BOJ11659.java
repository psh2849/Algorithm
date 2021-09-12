package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			System.out.println(arr[d] - arr[s - 1]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
