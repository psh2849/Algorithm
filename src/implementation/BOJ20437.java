package implementation;

import java.util.*;
import java.io.*;

public class BOJ20437 {

	static int t, k;
	static int[] alpha = new int[26];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			k = Integer.parseInt(br.readLine());

			int count = 0;
			int first_len = 10001;
			int second_len = 0;
			alpha = new int[26];
			
			if (k == 1) {
				System.out.println("1 1");
				continue;
			}

			for (int i = 0; i < str.length(); i++) {
				alpha[str.charAt(i) - 'a']++;
			}

			for (int i = 0; i < str.length(); i++) {
				if (alpha[str.charAt(i) - 'a'] < k)
					continue;

				count = 1;
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						count++;
					}

					if (count == k) {
						first_len = Math.min(first_len, j - i + 1);
						second_len = Math.max(second_len, j - i + 1);
						break;
					}
				}
			}

			if (first_len == 10001 && second_len == 0) {
				System.out.println(-1);
			} else {
				System.out.println(first_len + " " + second_len);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
