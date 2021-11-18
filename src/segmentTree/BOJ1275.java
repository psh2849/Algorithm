package segmentTree;

import java.util.*;
import java.io.*;

public class BOJ1275 {

	static int n, q;
	static long[] arr, tree;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		arr = new long[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new long[n * 4];
		initTree(1, n, 1);

		for (int i = 0; i < q; i++) {
			long ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (a > b) {
				int temp = b;
				b = a;
				a = temp;
			}
			
			ans = sum(1, n, 1, a, b);
			System.out.println(ans);
			update(1, n, 1, c, d);
		}
	}

	static long initTree(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = initTree(start, mid, node * 2) + initTree(mid + 1, end, node * 2 + 1);
	}

	static long sum(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return 0;
		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	static long update(int start, int end, int node, int idx, long diff) {
		if (idx < start || idx > end)
			return tree[node];

		if (start == end) {
			return tree[node] = diff;
		}

		int mid = (start + end) / 2;
		
		return tree[node] = update(start, mid, node * 2, idx, diff) + update(mid + 1, end, node * 2 + 1, idx, diff);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
