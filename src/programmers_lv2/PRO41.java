/*
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 */
package programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class PRO41 {
	
	static ArrayList<Integer> solution(String msg) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		int cnt = 27;
		
		for(int i = 0; i < 26; i++) {
			map.put(String.valueOf((char) (65 + i)), i + 1);
		}
		
		for(int i = 0; i < msg.length(); i++) {
			String str = "";
			int save = 0;
			int count = 0;
			
			for(int j = i; j < msg.length(); j++) {
				str += msg.charAt(j);
				
				if(map.containsKey(str)) {
					save = map.get(str);
				} 
				else {
					if(count > 1) {
						i = i + count - 1;
					}
					map.put(str, cnt);
					cnt++;
					list.add(save);
					save = 0;
					break;
				}
				count++;
			}
			
			if(save != 0) {
				list.add(save);
				i = i + count - 1;
			}
		}
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("TOBEORNOTTOBEORTOBEORNOT");
	}

}
