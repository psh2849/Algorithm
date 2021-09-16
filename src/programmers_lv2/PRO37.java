/*
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
package programmers_lv2;

public class PRO37 {
	
	static int[] solution(int n) {
		int[] answer = new int[(n*(n+1)) / 2];
		int[][] map = new int[n][n];
		int x = - 1, y = 0;
		int num = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				System.out.println(i);
				if(i % 3 == 0) {
					x++;
				} else if(i % 3 == 1) {
					y++;
				} else if(i % 3 == 2) {
					x--;
					y--;
				}
				
				map[x][y] = num++;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					answer[cnt++] = map[i][j];
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5);
	}

}
