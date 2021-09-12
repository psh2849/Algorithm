/*
 * 20364. 부동산 다툼
 */
package graph;

import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ20364 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int n, Q;
	static int[] estate;
	static HashSet<Integer> set = new HashSet<>();

	static void input() throws IOException {
		n = scan.nextInt();
		Q = scan.nextInt();

	}

	static void pro() {
		for (int i = 0; i < Q; i++) {
			int cur = scan.nextInt();
			int t = cur;
			int temp = 0;
			
			while(true) {
				if(t == 0) break;
				if(set.contains(t)) temp = t;
				t/=2;
			}
			
			if(temp == 0) {
				set.add(cur);
			}
			System.out.println(temp);
		}

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
