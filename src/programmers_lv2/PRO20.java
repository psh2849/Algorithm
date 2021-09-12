/*
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
package programmers_lv2;

public class PRO20 {

	static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int x = 0;
		int y = 0;

		for (y = 3; y < (brown + 4) / 2; y++) {
			x = ((brown + 4) / 2) - y;
			if (x < y)
				break;

			int yellowCnt = (x - 2) * (y - 2);
			if(yellow == yellowCnt) {
				break;
			}
		}
		
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10, 2);
	}

}
