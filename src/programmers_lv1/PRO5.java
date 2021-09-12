/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/70128
 */
package programmers_lv1;

public class PRO5 {
	
	static int solution(int[] a, int[] b) {
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		
		System.out.println(answer);
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		solution(a,b);
	}

}
