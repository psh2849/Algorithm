/*
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
package programmers_lv1;

public class PRO15 {

	static int[] score;
	static int score_cnt, bonus_cnt, option_cnt;
	static char[] bonus;
	static char[] option;

	static int solution(String dartResult) {
		int answer = 0;
		
		score = new int[3];
		bonus = new char[3];
		option = new char[3];
		
		for (int i = 0; i < dartResult.length(); i++) {
			if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
				if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
					score[score_cnt] = 10;
					i++;
				} else {
					score[score_cnt] = dartResult.charAt(i) - '0';
				}

				score_cnt++;
			} else if (dartResult.charAt(i) >= 'A' && dartResult.charAt(i) <= 'Z') {
				if (dartResult.charAt(i) == 'S') {
					score[bonus_cnt] = (int) Math.pow(score[bonus_cnt], 1);
				} else if (dartResult.charAt(i) == 'D') {
					score[bonus_cnt] = (int) Math.pow(score[bonus_cnt], 2);
				} else if (dartResult.charAt(i) == 'T') {
					score[bonus_cnt] = (int) Math.pow(score[bonus_cnt], 3);
				}

				bonus_cnt++;
			} else if (dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#') {
				if (dartResult.charAt(i) == '#') {
					score[score_cnt - 1] = score[score_cnt - 1] * -1;
				} else if (dartResult.charAt(i) == '*') {
					if (score_cnt <= 1) {
						score[score_cnt - 1] = score[score_cnt - 1] * 2;
					} else {
						score[score_cnt - 1] = score[score_cnt - 1] * 2;
						score[score_cnt - 2] = score[score_cnt - 2] * 2;
					}
				}
			}
		}

		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("1S*2T*3S");
	}

}
