package implementation;

import java.io.*;
import java.util.*;

public class BOJ2847 {

	static int n;
	static int[] level;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		level = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			level[i] = num;
		}

		pro();
	}

	static void pro() {
		int ans = 0;

		for (int i = n - 1; i > 0; i--) {
			if (level[i - 1] >= level[i]) {
				ans += level[i - 1] - level[i] + 1;
				level[i-1] = level[i] - 1;
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
