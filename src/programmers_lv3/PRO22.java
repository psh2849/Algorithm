/*
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 */
package programmers_lv3;

public class PRO22 {

	static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int idx = 0;
		int position = 1;
		
		while(position <= n) {
			if(idx < stations.length && stations[idx] - w <= position) {
				position = stations[idx] + w + 1;
				idx++;
			}
			else {
				answer++;
				position += (w * 2) + 1;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stations = { 4, 11 };
		solution(11, stations, 1);
	}

}
