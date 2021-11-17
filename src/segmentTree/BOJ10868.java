package segmentTree;

import java.util.*;
import java.io.*;

public class BOJ10868 {

	static int n, m;
	static int[] arr, mintree;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		mintree = new int[n * 4];
		minInit(1, n, 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int ans = minFind(1, n, 1, a, b);
			System.out.println(ans);
		}
	}

	static int minInit(int start, int end, int node) {
		if (start == end) {
			return mintree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return mintree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}

	static int minFind(int start, int end, int node, int left, int right) {
		if(left > end || start > right) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && right >= end) {
			return mintree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2+ 1, left, right));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
