/*
 * https://programmers.co.kr/learn/courses/30/lessons/12944
 */
package programmers_lv1;

public class PRO41 {
	
	static double solution(int[] arr) {
		double answer = 0;
		
		for(int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		answer = answer / arr.length;
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
