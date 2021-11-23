package etc;

import java.util.*;
import java.io.*;

public class BOJ6588 {

	static boolean[] prime = new boolean[1000000];
	static int max = Integer.MIN_VALUE;
	static int ans1, ans2;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 3; i < 1000000; i += 2) {
			if (isPrime(i)) {
				prime[i] = true;
			}
		}

		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				break;
			}
			boolean isPossible = false;
			for (int i = 3; i <= num / 2; i++) {
				if (prime[i] && prime[num - i]) {
					isPossible = true;
					System.out.println(num + " = " + i + " + " + (num - i));
					break;
				}
			}

			if (!isPossible) {
				System.out.println("Goldbach's conjecture is wrong.");
			}

		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
