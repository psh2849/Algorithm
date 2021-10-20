/*
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */

package programmers_lv3;

import java.util.Arrays;

public class PRO4 {
	static long answer;
	static long solution(long n, int[] times) {
		answer = 0;
		Arrays.sort(times);
		binarySearch(n, times);
		
		return answer;
	}
	
	static void binarySearch(long n, int[] times) {
		long left = 0;
		long right = n * times[times.length - 1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for(int i = 0; i < times.length; i++) {
				sum += mid / times[i];
			}
			if(sum < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] times = {7, 10};
		
		solution(6, times);
	}

}
