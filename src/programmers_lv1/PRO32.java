/*
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
package programmers_lv1;

public class PRO32 {

	static String solution(String s) {
		String answer = "";
		String[] str = s.split(" ", -1);

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				char ch = str[i].charAt(j);

				if (j % 2 == 0) {
					if (ch >= 'a' && ch <= 'z') {
						answer += (char) (ch - 32);
					} else {
						answer += ch;
					}
					
				} else {
					if (ch >= 'A' && ch <= 'Z') {
						answer += (char) (ch + 32);
					} else {
						answer += ch;
					}
				}
			}
			if(i != str.length - 1) {
				answer += " ";
			}
		}

		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("Rry hello worLd");
	}

}
