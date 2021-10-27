/*
 * https://programmers.co.kr/learn/courses/30/lessons/67258
 */
package programmers_lv3;

import java.util.*;

public class PRO16 {
	static int[] solution(String[] gems) {
		int[] answer = new int[2];
		HashMap<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String gem : gems) {
			set.add(gem);
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		while (right != gems.length) {
			if(map.size() == set.size()) {
				map.put(gems[left], map.get(gems[left]) - 1);
				if(map.get(gems[left]) == 0) {
					map.remove(gems[left]);
				}
				left++;
			} else {
				map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
				right++;
			}
			
			if(map.size() == set.size()) {
				if(right - left < min) {
					answer[0] = left + 1;
					answer[1] = right;
					min = right - left;
				}	
			}
		}

		System.out.println(answer[0] + " " + answer[1]);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		solution(gems);
	}

}
