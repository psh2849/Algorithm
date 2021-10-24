/*
 * https://programmers.co.kr/learn/courses/30/lessons/12927
 */
package programmers_lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class PRO12 {
	static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int work : works) {
			queue.add(work);
		}
		
		while(n--> 0) {
			int work = queue.poll();
			if(work == 0) {
				queue.add(0);
				continue;
			}
			work--;
			queue.add(work);
		}
		
		while(!queue.isEmpty()) {
			int work = queue.poll();
			answer += work * work;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] works = { 1,1 };
		solution(3, works);

	}

}
