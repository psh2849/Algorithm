/*
 * https://programmers.co.kr/learn/courses/30/lessons/12919
 */
package programmers_lv1;

import java.util.Arrays;

public class PRO26 {
	
	static String solution(String[] seoul) {
		String answer = "";
		
		int x = Arrays.asList(seoul).indexOf("Kim");
		answer += "김서방은 " + x + "에 있다";
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] seoul = {"Jane", "Kim"};
		solution(seoul);
	}

}
