/*
 * https://programmers.co.kr/learn/courses/30/lessons/72413
 */
package programmers_lv3;

public class PRO25 {
	
	static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] map = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = 20000001;
			}
			map[i][i] = 0;
		}
		
		for(int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] = fares[i][2];
			map[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		for(int k = 1; k <= n; k++) { 
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			System.out.println(map[s][i] + map[i][a] + map[i][b]);
			min = Math.min(min, map[s][i] + map[i][a] + map[i][b]);
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] fares = {{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};
		solution(6, 4, 6, 2, fares);
	}

}
