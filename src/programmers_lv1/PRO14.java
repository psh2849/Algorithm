/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/17681
 */
package programmers_lv1;

public class PRO14 {

	static char[][] map;

	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			pro(n, arr1[i], i);
			pro(n, arr2[i], i);
		}
	
		for (int i = 0; i < n; i++) {
			answer[i] = "";
			for (int j = 0; j < n; j++) {
				if(map[i][j] == '1') {
					answer[i] += "#";
				} else {
					answer[i] += " ";
				}
			}
		}
		
		return answer;
	}

	static void pro(int n, int num, int index) {
		int cnt = 0;
		String str = "";
		while (num >= 1) {
			int temp = num % 2;
			num = num / 2;
			cnt++;
			str += temp;
		}

		while (cnt < n) {
			str += 0;
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();

		for (int i = 0; i < n; i++) {
			if (map[index][i] == '0' && reverse.charAt(i) == '1') {
				map[index][i] = '1';
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		solution(5, arr1, arr2);
	}

}
