/*
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
package programmers_lv2;

import java.util.Arrays;

public class PRO22 {
	
	static int solution(int[] citations) {
		Arrays.sort(citations);
		int num = citations[citations.length - 1];
		int[] save = new int[num + 1];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= num; i++) {
			for(int j = 0; j < citations.length; j++) {
				if(citations[j] >= i) {
					save[i]++;
				}
			}
			if(i <= save[i]) {
				max = Math.max(i, max);
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3,0,6,1,5};
		solution(citations);
	}

}
