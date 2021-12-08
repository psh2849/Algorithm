package graph;

import java.util.*;
import java.io.*;

public class BOJ1963 {

	static class Prime {
		int number;
		int cnt;

		public Prime(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
	}

	static int answer = Integer.MAX_VALUE;
	static int t;
	static boolean[] isNotPrime = new boolean[10000];
	static int[] dir = { 1000, 100, 10, 1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		findPrime();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			answer = Integer.MAX_VALUE;
			pro(start, end);
		}
	}

	static void findPrime() {
		for (int i = 2; i < 10000; i++) {
			if (isNotPrime[i])
				continue;
			for (int j = i * i; j < 10000; j += i) {
				isNotPrime[j] = true;
			}
		}
	}

	static void pro(int start, int end) {
		Queue<Prime> queue = new LinkedList<>();
		boolean[] visit = new boolean[10000];
		queue.add(new Prime(start, 0));
		visit[start] = true;
	
		while (!queue.isEmpty()) {
			Prime num = queue.poll();
			int value = num.number;
			
			if (value == end) {
				answer = Math.min(answer, num.cnt);
			}

			int[] numbers = { value / 1000, (value / 100) % 10, (value / 10) % 10, value % 10 };
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					if (i == 0 && j == 0)
						continue;

					int temp = numbers[i];
					numbers[i] = j;
					int change = change(numbers);
					numbers[i] = temp;
					
					if(change < 1000) continue;
					if (isNotPrime[change] || visit[change])
						continue;
					
					queue.add(new Prime(change, num.cnt + 1));
					visit[change] = true;
				}
			}
		}

		System.out.println(answer);

	}

	static int change(int[] numbers) {
		int num = 0;
		for (int i = 0; i < 4; i++) {
			num += numbers[i] * (Math.pow(10, 3 - i));
		}

		return num;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
