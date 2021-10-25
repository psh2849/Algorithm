/*
 * https://programmers.co.kr/learn/courses/30/lessons/64064
 */
package programmers_lv3;

import java.util.*;

public class PRO14 {
	static HashSet<HashSet<String>> answer;
	static int solution(String[] user_id, String[] banned_id) {
		Set<String> set = new LinkedHashSet<>();
		answer = new HashSet<HashSet<String>>();
		dfs(user_id, banned_id, set);
		return answer.size();
	}

	static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
		if (set.size() == banned_id.length) {
			if(compareId(set, banned_id)) {
				answer.add(new HashSet<>(set));
			} 
			
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (!set.contains(user_id[i])) {
				set.add(user_id[i]);
				dfs(user_id, banned_id, set);
				set.remove(user_id[i]);
			}
		}
	}

	static boolean compareId(Set<String> set, String[] banned_id) {
		int i = 0;
		
		for(String id : set) {
			if(!isSame(id, banned_id[i++])) {
				return false;
			}
		}
		
		return true;
	}

	static boolean isSame(String id, String banned_id) {
		if(id.length() != banned_id.length()) {
			return false;
		}
		
		for(int i = 0; i < id.length(); i++) {
			if(banned_id.charAt(i) == '*') continue;
			if(banned_id.charAt(i) != id.charAt(i)) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
