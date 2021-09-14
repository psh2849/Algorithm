/*
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
package programmers_lv2;

import java.util.Arrays;

public class PRO30 {

	static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		int j = 0;
		for(int i= people.length - 1; j <= i; i--) {
			if(people[i] + people[j] > limit) {
				answer++;
			} else {
				answer++;
				j++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = { 40, 50, 150, 160 };
		solution(people, 200);
	}

}
