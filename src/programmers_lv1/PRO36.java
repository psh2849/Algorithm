/*
 * https://programmers.co.kr/learn/courses/30/lessons/12934
 */
package programmers_lv1;

public class PRO36 {
	static long solution(long n) {
		long answer = 0;
		Double num = Math.sqrt(n);
		if(num == num.intValue()) {
			answer = (long) Math.pow(num + 1, 2);
		} else {
			answer = -1;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(50000000000000L);
		solution(121);
		solution(3);
	}

}
