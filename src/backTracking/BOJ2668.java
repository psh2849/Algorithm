package backTracking;

import java.util.*;
import java.io.*;

public class BOJ2668 {
	static int n, idx;
	static boolean isBool;
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[] cards;
	static boolean[] visit;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visit = new boolean[n + 1];
		cards = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			visit[i] = true;
			idx = i;
			dfs(i);
			visit[i] = false;
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	static void dfs(int k) {
		if(cards[k] == idx) {
			answer.add(idx);
		}
		
		if(!visit[cards[k]]) {
			visit[cards[k]] = true;
			dfs(cards[k]);
			visit[cards[k]] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
