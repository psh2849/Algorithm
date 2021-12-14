package topologicalSort;

import java.util.*;
import java.io.*;

public class BOJ14567 {
	
	static int n, m;
	static ArrayList<Integer>[] adj;
	static int[] degree;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree = new int[n + 1];
		adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			degree[b]++;
		}
	
		pro();	
	}
	
	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int[] result = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			result[i] = 1;
			if(degree[i] == 0) {
				queue.add(i);
			}
		}
		
		int cnt = 2;
		while(!queue.isEmpty()) {
			while(!queue.isEmpty()) {
				int subject = queue.poll();
				list.add(subject);
			}
			
			for(int num : list) {
				for(int i : adj[num]) {
					degree[i]--;
					
					if(degree[i] == 0) {
						queue.add(i);
						result[i] = cnt;
					}
				}
			}
			
			list.clear();
			cnt++;
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(result[i] + " ");
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
