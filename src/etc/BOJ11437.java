package etc;

import java.util.*;
import java.io.*;

public class BOJ11437 {

	static int n, m;
	static int[] depth;
	static int[] parent;
	static ArrayList<Integer>[] list;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			list[a].add(b);
			list[b].add(a);
		}

		depth = new int[n + 1];
		parent = new int[n + 1];
		m = Integer.parseInt(br.readLine());
		dfs(1, 1);
		
		for(int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			int res = solve(a, b);
			
			System.out.println(res);
		}
	}
	
	static int solve(int a, int b) {
		int depthA = depth[a];
		int depthB = depth[b];
		
		if(depthA > depthB) {
			while(depthA != depthB) {
				depthA--;
				a = parent[a];
			}
		} else {
			while(depthA != depthB) {
				depthB--;
				b = parent[b];
			}
		}
		
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	static void dfs(int k, int cnt) {
		depth[k] = cnt;
		
		for(int num : list[k]) {
			if(depth[num] == 0) {
				dfs(num, cnt + 1);
				parent[num] = k;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
