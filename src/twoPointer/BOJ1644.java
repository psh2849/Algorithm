package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1644 {

	static int N;
	static long sum = 0;
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		list.add(2);

		for (int i = 3; i <= N; i++) {
			boolean isBool = isPrime(i);
			if (isBool) {
				list.add(i);
			}
		}

		pro();
	}

	static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	static void pro() {
		int left = 0;
		int right = 0;

		while (true) {
			if (sum == N) {
				cnt++;
				sum -= list.get(left);
				left++;
			}
			else if (sum > N) {
				sum -= list.get(left);
				left++;
			}
			else if (right == list.size()) {
				break;
			}
			else {
				sum += list.get(right);
				right++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
