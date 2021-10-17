/*
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */
package programmers_lv2;

public class PRO46 {
	
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static int answer = 0;
	static int solution(int n, String[] data) {
		boolean[] visit = new boolean[8];
		answer = 0;
		dfs("", visit, data);
		return answer;
	}
	
	static void dfs(String names, boolean[] visit, String[] data) {
		if(names.length() == 7) {
			if(check(names, data)) {
				answer++;
			}
			
			return;
		} 
		
		for(int i = 0; i < 8; i++) {
			if(!visit[i]) {
				visit[i] = true;
				String name = names + friends[i];
				dfs(name, visit, data);
				visit[i] = false;
			}
		}
	}
	
	static boolean check(String names, String[] datas) {
		for(String data : datas) {
			int pos1 = names.indexOf(data.charAt(0));
			int pos2 = names.indexOf(data.charAt(2));
			char op = data.charAt(3);
			int len = data.charAt(4) - '0';
			
			if(op == '=') {
				if(!(Math.abs(pos1-pos2) == len + 1)) return false;
			} else if(op == '>') {
				if(!(Math.abs(pos1-pos2) > len + 1)) return false;
			} else if(op == '<') {
				if(!(Math.abs(pos1-pos2) < len + 1)) return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"N~F=0", "R~T>2"};
		
		solution(2, data);
	}

}
