/*
 * 16472. ∞Ì≥…¿Ã
 */
package twoPointer;

import java.util.Scanner;

public class BOJ16472 {

	static int N;
	static String A;
	static int[] ch = new int[26];
	static int kind = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = sc.next();

	}

	static void add(char x) {
		ch[x - 'a']++;
		if (ch[x - 'a'] == 1) {
			kind++;
		}
	}

	static void erase(char x) {
		ch[x - 'a']--;
		if (ch[x - 'a'] == 0) {
			kind--;
		}
	}

	static void pro() {
		int left = 0;
		int min = Integer.MIN_VALUE;
		for (int right = 0; right < A.length(); right++) {
			add(A.charAt(right));
			
			while(kind > N) {
				erase(A.charAt(left));
				left++;
			}
			
			min = Math.max(min, right - left + 1);
		}
		
		System.out.println(min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
