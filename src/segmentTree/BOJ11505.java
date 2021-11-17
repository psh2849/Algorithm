package segmentTree;

import java.util.*;
import java.io.*;

public class BOJ11505 {

	static int n, m, k;
	static long[] arr, tree;
	static int mod = 1000000007;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		tree = new long[n * 4];
		
		treeInit(1, n, 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				update(1, n, 1, b, c);
			} else if (a == 2) {
				long ans = mul(1, n, 1, b, (int) c);
				System.out.println(ans);
			}
		}

	}

	static long treeInit(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = (treeInit(start, mid, node * 2) * treeInit(mid + 1, end, node * 2 + 1)) % mod;
	}

	static long update(int start, int end, int node, int idx, long diff) {
		if (idx > end || idx < start) {
			return tree[node];
		}

		if (start == end)
			return tree[node] = diff;
		
		int mid = (start + end) / 2;
		
		return tree[node] = (update(start, mid, node * 2, idx, diff) * update(mid + 1, end, node * 2 + 1, idx, diff)) % mod;
	}
	
	static long mul(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 1;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		
		return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % mod;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();

	}

}
