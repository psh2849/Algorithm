/*
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */

package programmers_lv1;

public class PRO49 {

	static int solution(int[][] sizes) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < sizes.length; i++) {
			int max = Math.max(sizes[i][0], sizes[i][1]);
			int min = Math.min(sizes[i][0], sizes[i][1]);
			
			x = Math.max(x, max);
			y = Math.max(y, min);
		}
		
		return x * y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

		solution(sizes);
	}
}
