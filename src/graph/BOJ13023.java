package graph;

import java.util.*;
import java.io.*;

public class BOJ13023 {

	static int n, m, ans = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			if(ans == 0) {
				pro(i, 1);
			}
		}
		
		System.out.println(ans);
	}
	
	static void pro(int start, int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		visit[start] = true;
		for(int p : list[start]) {
			if(!visit[p]) {
				pro(p, depth + 1);
			}
		}
		visit[start] = false;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
