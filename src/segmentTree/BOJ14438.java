package segmentTree;

import java.util.*;
import java.io.*;

public class BOJ14438 {

	static int n, m;
	static int[] arr, tree;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new int[n * 4];
		init(1, n, 1);
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				update(1, n, 1, b, c);
			} else if (a == 2) {
				int ans = mintree(1, n, 1, b, c);
				System.out.println(ans);
			}
		}
	}

	static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = start;
		} else {
			int mid = (start + end) / 2;
			init(start, mid, node * 2);
			init(mid + 1, end, node * 2 + 1);

			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
			}
		}
	}

	static void update(int start, int end, int node, int idx, int diff) {
		if (idx < start || idx > end) {
			return;
		}

		if (start == end) {
			tree[node] = idx;
			arr[idx] = diff;
			return;
		}
			

		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
		
		if(arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}

	}

	static int mintree(int start, int end, int node, int left, int right) {
		if (left > end || start > right)
			return -1;
		if (left <= start && right >= end)
			return tree[node];

		int mid = (start + end) / 2;
		int t1 = mintree(start, mid, node * 2, left, right);
		int t2 = mintree(mid + 1, end, node * 2 + 1, left, right);
		
		if(t1 == -1) {
			return t2;
		} else if(t2 == -1) {
			return t1;
		} else {
			if(arr[t1] <= arr[t2]) {
				return t1;
			} else {
				return t2;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
