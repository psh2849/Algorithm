package graph;

import java.util.*;
import java.io.*;

public class BOJ17471 {
	static int n, ans = Integer.MAX_VALUE;
	static int[] person;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> arr = new ArrayList<>();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		person = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int a = Integer.parseInt(st.nextToken());
				list[i].add(a);
			}
		}
		
		for(int i = 1; i <= n / 2; i++) {
			dfs(1, i);
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	static void dfs(int start, int r) {
		if(r == 0) {
			cal();
			return;
		}
		
		for(int i = start; i <= n; i++) {
			arr.add(i);
			dfs(i + 1, r - 1);
			arr.remove(arr.size() - 1);
		}
	}
	
	static void cal() { 
		if(!connect(arr)) {
			return;
		}
		
	    ArrayList<Integer> arr2 = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(!arr.contains(i)) {
				arr2.add(i);
			}
		}
		
		if(!connect(arr2)) {
			return;
		}
		
		int sumA = 0;
		for(int i = 0; i < arr.size(); i++) {
			int value = arr.get(i);
			sumA += person[value];
		}
		
		int sumB = 0;
		for(int i = 0; i < arr2.size(); i++) {
			int value = arr2.get(i);
			sumB += person[value];
		}
		
		int res = Math.abs(sumA - sumB);
		ans = Math.min(ans, res);
	}
	
	static boolean connect(ArrayList<Integer> city) {
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(city.get(0));
		visit[city.get(0)] = true;
		int cnt = 1;
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(int e : list[p]) {
				if(visit[e]) continue;
				if(city.contains(e)) {
					visit[e] = true;
					cnt++;
					queue.add(e);
				}
			}
		}
		
		if(cnt == city.size()) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
