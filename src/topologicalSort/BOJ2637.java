package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2637 {

	static class Point {
		int idx;
		int val;

		public Point(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	static int N, M;
	static boolean[] isNoDegree;
	static int[] need, indeg;
	static ArrayList<Point>[] list;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		indeg = new int[N + 1];
		need = new int[N + 1];
		isNoDegree = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			isNoDegree[i] = true;
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			indeg[y]++;
			list[x].add(new Point(y, value));
			isNoDegree[x] = false;
		}
		
		pro();
	}
	
	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		need[N] = 1;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			int cnt = need[index];
			
			for(Point p : list[index]) {
				int next = p.idx;
				int val = p.val;
				indeg[next]--;
				need[next] += cnt * p.val;
				
				if(indeg[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(isNoDegree[i]) {
				System.out.println(i + " " + need[i] + " ");
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
