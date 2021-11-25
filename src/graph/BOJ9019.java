package graph;

import java.util.*;
import java.io.*;

public class BOJ9019 {
	
	static int n;
	static String[] str;
	static boolean[] visit;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		while(n --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			
			str = new String[10000];
			visit = new boolean[10000];
			
			pro(start, dest);
		}
	}
	
	static void pro(int start, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;
		Arrays.fill(str, "");
		
		while(!queue.isEmpty() && !visit[dest]) {
			int p = queue.poll();
			int D = (p * 2) % 10000;
			int S = (p == 0) ? 9999 : p - 1;
			int L = (p % 1000) * 10 + (p / 1000);
			int R = (p % 10) * 1000 + (p / 10);
			
			if(!visit[D]) {
				queue.add(D);
				visit[D] = true;
				str[D] = str[p] + "D";
			}
			if(!visit[S]) { 
				queue.add(S);
				visit[S] = true;
				str[S] = str[p] + "S";
			}
			if(!visit[L]) {
				queue.add(L);
				visit[L] = true;
				str[L] = str[p] + "L";
			}
			if(!visit[R]) {
				queue.add(R);
				visit[R] = true;
				str[R] = str[p] + "R";
			}
		}
		
		System.out.println(str[dest]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
