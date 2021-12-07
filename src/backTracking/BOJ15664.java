package backTracking;

import java.util.*;
import java.io.*;

public class BOJ15664 {

	static int[] visit;
	static int[] arr;
	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visit = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		pro(0, 0);
	}

	static void pro(int start, int count) {
		if (count == m) {
			for (int i = 0; i < n; i++) {
				if (visit[i] != 0) {
					System.out.print(visit[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		int before = -1;
		for (int i = start; i < n; i++) {
			if (before != arr[i]) {
				visit[start] = arr[i];
				before = arr[i];
				pro(i + 1, count + 1);
				visit[start] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
