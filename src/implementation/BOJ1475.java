package implementation;

import java.util.Scanner;

public class BOJ1475 {

	static void input() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = "";
		str += n;
		int[] count = new int[10];
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			count[num]++;
		}

		int num = count[6] + count[9];
		if (num % 2 == 0) {
			count[6] = num / 2;
			count[9] = num / 2;
		} else {
			count[6] = num / 2 + 1;
			count[9] = num / 2 + 1;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();

	}

}
