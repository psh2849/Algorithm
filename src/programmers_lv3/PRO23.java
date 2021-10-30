/*
 * https://programmers.co.kr/learn/courses/30/lessons/12971
 */
package programmers_lv3;

public class PRO23 {
	
	static int[] dp1, dp2;
	static int solution(int[] sticker) {
		dp1 = new int[sticker.length];
		dp2 = new int[sticker.length];
		
		if(sticker.length == 1) {
			return sticker[0];
		}
		
		dp1[0] = sticker[0];
		dp1[1] = sticker[0];
		
		dp2[0] = 0;
		dp2[1] = sticker[1];
		for(int i = 2; i < sticker.length; i++) {
			dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
			dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
		}
		
		return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
		solution(sticker);
	}

}
