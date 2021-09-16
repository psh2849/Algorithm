/*
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */
package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class PRO39 {
	static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> queue = new LinkedList<>();
		
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toLowerCase();
			
			if (queue.size() < cacheSize) {
				if (!queue.contains(cities[i])) {
					queue.add(cities[i]);
					answer += 5;
				} else {
					queue.remove(cities[i]);
					queue.add(cities[i]);
					answer++;
				}
			} else {
				if(!queue.contains(cities[i])) {
					queue.poll();
					queue.add(cities[i]);
					answer += 5;
				} else {
					queue.remove(cities[i]);
					queue.add(cities[i]);
					if(cacheSize == 0) {
						answer += 5;
					} else {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cities = { "LA", "LA" };
		solution(0, cities);
	}

}
