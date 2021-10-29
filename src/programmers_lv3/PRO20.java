/*
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */
package programmers_lv3;

import java.util.*;

public class PRO20 {

	static int[] parent;
	
	static int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		
		for(int i = 0; i < costs.length; i++) {
			int first = find(costs[i][0]);
			int second = find(costs[i][1]);
			
			if(first != second) {
				parent[second] = first;
				answer += costs[i][2];
			}
		}
		
		return answer;
	}

	static int find(int child) {
		if(parent[child] == child) {
			return child;
		} else {
			return parent[child] = find(parent[child]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		solution(4, costs);
	}

}
