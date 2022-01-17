package programmers_lv1;

import java.util.*;

public class PRO50 {
	
	static HashSet<String> set = new HashSet<>();
	static HashMap<String, Integer> map = new HashMap<>();
	static HashMap<String, Integer> id = new HashMap<>();
	
	static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		
		for(int i = 0; i < report.length; i++) {
			set.add(report[i]);
		}
		
		for(String s : set) {
			String[] split = s.split(" ");
			
			if(map.containsKey(split[1])) {
				map.put(split[1], map.get(split[1]) + 1);
			} else {
				map.put(split[1], 1);
			}
		}
	
		for(String s: set) {
			String[] split = s.split(" ");
			
			if(map.get(split[1]) >= k) {
				if(id.containsKey(split[0])) {
					id.put(split[0], id.get(split[0]) + 1);
				} else {
					id.put(split[0], 1);
				}
			}
		}
		
		for(int i = 0; i < id_list.length; i++) {
			if(id.get(id_list[i]) == null) {
				answer[i] = 0;
			} else {
				answer[i] = id.get(id_list[i]);
			}
			
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id = {"muzi","frodo","apeach","neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		
		solution(id, report, 2);
	}

}
