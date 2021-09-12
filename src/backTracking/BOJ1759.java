/*
 * 1759. 암호 만들기
 */
package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1759 {

	static int N, M;
	static int[] selected;
	static char[] chars;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		chars = new char[M + 1];
		selected = new int[N + 1];

		str = br.readLine().split(" ");
		for (int i = 1; i <= M; i++) {
			chars[i] = str[i - 1].charAt(0);
		}

		Arrays.sort(chars, 1, M + 1);
	}

	static boolean isVowel(char x) {
		return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
	}

	static void pro(int k) {
		if (k == N + 1) {
			int vowel = 0, consonant = 0;

			for (int i = 1; i <= N; i++) {
				if (isVowel(chars[selected[i]]))
					vowel++;
				else
					consonant++;
			}

			if (vowel >= 1 && consonant >= 2) {
				for (int i = 1; i <= N; i++) {
					System.out.print(chars[selected[i]]);
				}
				System.out.println();
			}
		} else {
			for (int i = selected[k - 1] + 1; i <= M; i++) {
				selected[k] = i;
				pro(k + 1);
				selected[k] = 0;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro(1);
	}

}
