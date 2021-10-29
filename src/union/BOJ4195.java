package union;

import java.util.*;
import java.io.*;

public class BOJ4195 {
	
	static HashMap<String, Integer> map = new HashMap<>();
	static int[] parent, level;
	static int T, N;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		while(T--> 0) {
			N = Integer.parseInt(br.readLine());
			
			parent = new int[N * 2];
			level = new int[N * 2];
			for(int i = 0; i < N * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) {
					map.put(a, cnt++);
				}
				
				if(!map.containsKey(b)) {
					map.put(b, cnt++);
				}
				
				System.out.println(union(map.get(a), map.get(b)));
			}
		}
	}
	
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
			level[a] += level[b];	
		}
		
		return level[a];
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
