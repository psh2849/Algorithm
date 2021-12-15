package graph;

import java.util.*;
import java.io.*;

public class BOJ9466 {

	static int t, n, count;
	static int[] student;
	static boolean[] visit;
	static boolean[] finish;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			
			count = 0;
			finish = new boolean[n + 1];
			visit = new boolean[n + 1];
			student = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= n; i++) {
				pro(i);
			}
			
			System.out.println(n - count);
		}
	}
	
	static void pro(int num) {
		if(visit[num]) { 
			return;
		}
		
		visit[num] = true;
		int next = student[num];
		
		if(!visit[next]) {
			pro(next);
		} else {
			if(!finish[next]) {
				count++;
				for(int i = next; i != num; i = student[i]) {
					count++;
				}
			}
		}
		
		finish[num] = true;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
