package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17615 {

	static int n, red, blue;
	static String ball;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ball = br.readLine();

		for (int i = 0; i < n; i++) {
			if (ball.charAt(i) == 'R') {
				red++;
			} else {
				blue++;
			}
		}
		int min = Math.min(red, blue);

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (ball.charAt(0) != ball.charAt(i))
				break;
			count++;
		}

		if (ball.charAt(0) == 'R') {
			min = Math.min(min, red - count);
		} else {
			min = Math.min(min, blue - count);
		}

		count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (ball.charAt(n - 1) != ball.charAt(i))
				break;
			count++;
		}

		if (ball.charAt(n - 1) == 'R') {
			min = Math.min(min, red - count);
		} else {
			min = Math.min(min, blue - count);
		}

		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
