package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2056 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] time, saveTime;
	static int[] degree;
	static int max = Integer.MIN_VALUE;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		saveTime = new int[N + 1];
		time = new int[N + 1];
		degree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int s = Integer.parseInt(st.nextToken());
				list[s].add(i);
				degree[i]++;
			}
		}
		
		pro();
	}

	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				queue.add(i);
				saveTime[i] = time[i];
			}
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int e : list[num]) {
				degree[e]--;
				if(degree[e] == 0) {
					queue.add(e);
				}
				saveTime[e] = Math.max(saveTime[e], saveTime[num] + time[e]);
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, saveTime[i]);
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
