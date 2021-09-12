/*
 * 2309 ÀÏ°ö ³­ÀïÀÌ
 */
package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
	static int[] height;
	static int[] visit;
	static int sum = 0;
	static boolean flag = false;
	static void input() {
		Scanner sc = new Scanner(System.in);

		height = new int[10];
		visit = new int[10];

		for (int i = 1; i <= 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		Arrays.sort(height);
	}

	static void pro() {
		for (int i = 1; i <= 8 ; i++) {
			for (int j = i + 1; j <= 9; j++) {
				if (100 == sum - (height[i] + height[j])) {
					print(i, j);
					flag = true;
					return;
				}
			}
			if(flag == true) return;
		}
	}

	static void print(int ex1, int ex2) {
		for (int i = 1; i <= 9; i++) {
			if (i != ex1 && i != ex2) {
				System.out.println(height[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		input();
		pro();
	}

}
