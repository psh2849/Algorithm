package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1339 {
	static int N, answer;
	static int[] num;
	static String[] words;
	static boolean[] visit;
	static ArrayList<Character> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[10];
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			for (int j = 0; j < words[i].length(); j++) {
				if (!list.contains(words[i].charAt(j))) {
					list.add(words[i].charAt(j));
				}
			}
		}

		num = new int[list.size()];
		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int count) {
		if (count == list.size()) {
			int sum = 0;

			for (int i = 0; i < N; i++) {
				int value = 0;
				for (int j = 0; j < words[i].length(); j++) {
					value *= 10;
					value += num[list.indexOf(words[i].charAt(j))];
				}
				sum += value;
			}
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			num[count] = i;
			dfs(count + 1);
			visit[i] = false;
			num[count] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
