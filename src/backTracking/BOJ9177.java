/*
 * 1019. 책 페이지
 */
package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ9177 {

	static int N, cnt = 0;
	static boolean isPossible;
	static String first_word, second_word, result_word;
	static int first_len, second_len, result_len;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			isPossible = false;
			cnt++;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			first_word = st.nextToken();
			second_word = st.nextToken();
			result_word = st.nextToken();

			first_len = first_word.length();
			second_len = second_word.length();
			result_len = first_len + second_len;

			Set<Character> set = new HashSet<>();
			int max = Math.max(first_len, second_len);
			for (int i = 0; i < max; i++) {
				if (i < first_len)
					set.add(first_word.charAt(i));
				if (i < second_len)
					set.add(second_word.charAt(i));
			}

			boolean flag = true;
			for (int i = 0; i < result_len; i++) {
				if (!set.contains(result_word.charAt(i))) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				sb.append("Data set " + cnt + ": no\n");
				continue;
			}

			pro(0, 0, 0);
			
			if(isPossible) {
				sb.append("Data set " + cnt + ": yes\n");
			} else {
				sb.append("Data set " + cnt + ": no\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void pro(int k1, int k2, int cnt) {
		if(isPossible) return;
		
		if(k1 + k2 == result_len) {
			isPossible = true;
		} else {
			if(k1 < first_len && result_word.charAt(cnt) == first_word.charAt(k1)) {
				pro(k1 + 1, k2, cnt + 1);
			} 
			if(k2 < second_len && result_word.charAt(cnt) == second_word.charAt(k2)) {
				pro(k1, k2 + 1, cnt + 1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
