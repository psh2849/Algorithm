package programmers_lv3;

public class PRO32 {
	
	static int[] map;
	static int answer;
	static int solution(int n) {
		answer = 0;
		map = new int[n];
		dfs(n, 0);
		return answer;
	}
	
	static void dfs(int n, int depth) {
		if(depth == n) {
			answer++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			map[depth] = i;
			if(possible(depth)) {
				dfs(n, depth + 1);
			}
		}
	}
	
	static boolean possible(int depth) {
		for(int i = 0; i < depth; i++) {
			if(map[depth] == map[i]) {
				return false;
			}
			
			if(Math.abs(depth - i) == Math.abs(map[depth] - map[i])) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
