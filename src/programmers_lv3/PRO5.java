/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO5 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	
	static int solution(int n, int[][] computers) {
		int answer = n;
		
		visit = new boolean[computers.length];
		list = new ArrayList[computers.length];
		for (int i = 0; i < computers.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if(computers[i][j] == 1) {
					list[i].add(j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			answer -= bfs(n, i);
		}
		
		return answer;
	}
	
	static int bfs(int n ,int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;
		int cnt = 0;
	
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int e : list[p]) {
				if(visit[e]) continue;
				visit[e] = true;
				cnt++;
				queue.add(e);
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		solution(3,computers);
	}

}
