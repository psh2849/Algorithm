package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ2096 {

	static int n;
	static int[] maxDp;
	static int[] minDp;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		maxDp = new int[3];
		minDp = new int[3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[0] = minDp[0] = x1;
				maxDp[1] = minDp[1] = x2;
				maxDp[2] = minDp[2] = x3;
			} else {
				int saveDp0 = maxDp[0];
				int saveDp2 = maxDp[2];

				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x3;
				maxDp[1] = Math.max(Math.max(saveDp0, maxDp[1]), saveDp2) + x2;

				saveDp0 = minDp[0];
				saveDp2 = minDp[2];

				minDp[0] = Math.min(minDp[0], minDp[1]) + x1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + x3;
				minDp[1] = Math.min(Math.min(saveDp0, saveDp2), minDp[1]) + x2;
			}
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxDp[i]);
			min = Math.min(min, minDp[i]);
		}
		
		System.out.println(max + " " + min);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
