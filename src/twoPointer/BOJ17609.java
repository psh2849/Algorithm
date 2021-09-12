package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {

	static int N;
	static char[] arr;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr = str.toCharArray();
			int left = 0;
			int right = str.length() - 1;

			if (pro(left, right)) {
				System.out.println(0);
				continue;
			}

			if (pro2(left, right)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}

	static boolean pro(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	static boolean pro2(int left, int right) {
		boolean n1, n2;

		while (left <= right) {
			if (arr[left] != arr[right]) {
				n1 = pro(left + 1, right);
				n2 = pro(left, right - 1);

				if (!n1 && !n2) {
					return false;
				} else {
					return true;
				}
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
