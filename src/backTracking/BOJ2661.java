/*
 * 2661. 좋은 수열
 */
package backTracking;

import java.util.Scanner;

public class BOJ2661 {

	static int N;
	static int[] arr;
	static boolean is_end = false;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		pro("");
	}

	static void pro(String str) {
		if (is_end)
			return;
		if (str.length() == N) {
			System.out.println(str);
			is_end = true;
		} else {
			for (int i = 1; i <= 3; i++) {
				if(isAble(str + i)) {
					pro(str + i);
				}
			}
		}
	}

	static boolean isAble(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			String front = str.substring(str.length() - i - i, str.length() - i);
			String back = str.substring(str.length() -i, str.length());
			
			if(front.equals(back)) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		
	}

}
