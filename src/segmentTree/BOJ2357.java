package segmentTree;

import java.util.*;
import java.io.*;

public class BOJ2357 {

	static int n, m;
	static int[] arr, maxtree, mintree;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		maxtree = new int[n * 4];
		mintree = new int[n * 4];

		minInit(1, n, 1);
		maxInit(1, n, 1);

		for (int i = 1; i < maxtree.length; i++) {
			System.out.print(maxtree[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < mintree.length; i++) {
			System.out.print(mintree[i] + " ");
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int min = minFind(1, n, 1, a, b);
			int max = maxFind(1, n, 1, a, b);

			System.out.println(min + " " + max);
		}
	}

	static int minInit(int start, int end, int node) {
		if (start == end) {
			return mintree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return mintree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}

	static int maxInit(int start, int end, int node) {
		if (start == end) {
			return maxtree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return maxtree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
	}

	static int minFind(int start, int end, int node, int left, int right) {
		if (left > end || start > right) {
			return Integer.MAX_VALUE;
		}

		if (left <= start && end <= right) {
			return mintree[node];
		}

		int mid = (start + end) / 2;
		return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
	}

	static int maxFind(int start, int end, int node, int left, int right) {
		if (left > end || start > right) {
			return Integer.MIN_VALUE;
		}

		if (left <= start && end <= right) {
			return maxtree[node];
		}

		int mid = (start + end) / 2;

		return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
