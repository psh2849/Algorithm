package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 {

	static int N;
	static int[] deg;
	static int[] time, saveTime;
	static ArrayList<Integer>[] list;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		deg = new int[N+1];
		saveTime = new int[N+1];
		time = new int[N+1];
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			while(true) {
				int build = Integer.parseInt(st.nextToken());
				if(build == -1) break;
				list[build].add(i);
				deg[i]++;
			}
		}
		
		pro();
	}
	
	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(deg[i] == 0) {
				queue.add(i);
				saveTime[i] = time[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int j : list[p]) {
				saveTime[j] = Math.max(saveTime[j], saveTime[p] + time[j]);
				deg[j]--;
				if(deg[j] == 0) {
					queue.add(j);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(saveTime[i]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
