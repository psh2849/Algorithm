/*
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
package programmers_lv3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PRO7 {

	static class Job {
		int requestTime;
		int workTime;

		public Job(int requestTime, int workTime) {
			this.requestTime = requestTime;
			this.workTime = workTime;
		}
	}

	static int solution(int[][] jobs) {
		int answer = 0;
		int cnt = 0;
		LinkedList<Job> waitQueue = new LinkedList<>();
		PriorityQueue<Job> mainQueue = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				return o1.workTime - o2.workTime;
			}
		});

		for (int i = 0; i < jobs.length; i++) {
			waitQueue.add(new Job(jobs[i][0], jobs[i][1]));
		}

		Collections.sort(waitQueue, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				return o1.requestTime - o2.requestTime;
			}
		});

		int time = waitQueue.peek().requestTime;
		while (cnt < jobs.length) {
			while (!waitQueue.isEmpty() && waitQueue.peek().requestTime <= time) {
				mainQueue.add(waitQueue.pollFirst());
			}
			
			if(!mainQueue.isEmpty()) {
				Job job = mainQueue.poll();
				time += job.workTime;
				answer += (time - job.requestTime);
				cnt++;
			} else {
				time++;
			}
		}

		return answer / jobs.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		solution(jobs);
	}

}
