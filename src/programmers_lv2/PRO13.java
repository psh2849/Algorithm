/*
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */
package programmers_lv2;

public class PRO13 {
	static int solution(int[][] land) {
		int answer = Integer.MIN_VALUE;
		int[][] dp = new int[land.length][land[0].length];
		
		for(int i = 0; i < land[0].length; i++) {
			dp[0][i] = land[0][i];
		}
		
		for(int i = 1; i < land.length; i++) {
			for(int j = 0; j < land[0].length; j++) {
				int max = Integer.MIN_VALUE;
				
				for(int k = 0; k < 4; k++) {
					if(j == k) continue;
					
					max = Math.max(max, dp[i-1][k]);
				}
				dp[i][j] = land[i][j] + max;
			}
		}
		
		
		for(int i = 0; i < 4; i++) {
			answer = Math.max(answer, dp[land.length - 1][i]);
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] land = {{1,2,3,5}, {5,6,7,8},{4,3,20,1}};
		solution(land);
	}

}
