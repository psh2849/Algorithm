/*
 * https://programmers.co.kr/learn/courses/30/lessons/68646
 */
package programmers_lv3;

public class PRO29 {
	static int solution(int[] a) {
		int answer = 2;
		int left = a[0];
		int right = a[a.length - 1];
		for (int i = 1; i < a.length - 1; i++) {
			if (left > a[i]) {
				left = a[i];
				answer++;
			}
			if (right > a[a.length - 1 - i]) {
				right = a[a.length - 1 - i];
				answer++;
			}
		}
		
		if(left == right) {
			return answer -= 1;
		} else {
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
