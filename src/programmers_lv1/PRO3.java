/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/81301
 */
package programmers_lv1;

public class PRO3 {

	static String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static int solution(String s) {
		for(int i = 0; i < str.length; i++) {
			s = s.replaceAll(str[i], Integer.toString(i));
		}
		
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = solution("23four5six7");
		System.out.println(ans);
	}

}
