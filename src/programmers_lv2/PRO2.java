/*
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
package programmers_lv2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PRO2 {

	static String[] solution(String[] record) {
		String[] answer;
		String[] str = new String[record.length];
		List<String[]> list = new LinkedList<>();
		HashMap<String, String> hash = new HashMap<>();
		

		for (int i = 0; i < record.length; i++) {
			str = record[i].split(" ");

			if (str[0].equals("Enter")) {
				hash.put(str[1], str[2]);
				list.add(str);
			} else if (str[0].equals("Change")) {
				hash.put(str[1], str[2]);
			} else {
				list.add(str);
			}
		}

		answer = new String[list.size()];
		int cnt = 0;
		for (String[] key : list) {
			String name = hash.get(key[1]);
			
			if(key[0].equals("Enter")) {
				answer[cnt] = name + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
				cnt++;
			} else {
				answer[cnt] = name + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
				cnt++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = { "Enter uid123 uid1234", "Leave uid123", "Enter uid4567 uid123", "Change uid4567 uid1234",
				"Leave uid4567" };
		
		solution(record);
	}

}
