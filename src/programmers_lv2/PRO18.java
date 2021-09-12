/*
 * https://programmers.co.kr/learn/courses/30/lessons/17687 
 */

package programmers_lv2;

public class PRO18 {

	static String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder("");
		StringBuilder binaryStr = new StringBuilder("0");
		String[] alphaForMoreThan10 = { "A", "B", "C", "D", "E", "F" };
		
		int num = 1;
		while(binaryStr.length() - 1 < t * m) {
			StringBuilder subStr = new StringBuilder("");
			int quot = num;
			int remain;
			
			while(quot > 0) {
				remain = quot % n;
				quot = quot / n;
				
				if(remain >= 10 && remain <= 15) {
					subStr.append(alphaForMoreThan10[remain-10]);
				} else {
					subStr.append(remain);
				}
			}
			
			binaryStr.append(subStr.reverse());
			num++;
		}
		
		int temp = p;
		for(int i = 0; i < t; i++) {
			answer.append(binaryStr.charAt(temp - 1));
			temp += m;
		}
		return answer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(2, 4, 2, 1);
	}

}
