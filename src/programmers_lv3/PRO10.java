/*
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.Collections;

public class PRO10 {
	static int[] solution(String[] operations) {
		int[] answer = new int[2];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < operations.length; i++) {
			String[] str = operations[i].split(" ");
			int value = Integer.parseInt(str[1]);
			
			if(str[0].equals("I")) {
				list.add(value);
			} else if(str[0].equals("D")) {
				if(list.size() == 0) {
					continue;
				}
				Collections.sort(list);
				if(value == -1) {
					list.remove(0);
				} else {
					 list.remove(list.size() - 1);
				}
			}
		}
		
		if(list.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			Collections.sort(list);
			answer[0] = list.get(list.size() - 1);
			answer[1] = list.get(0);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"I 7","I 5","I -5","D -1"};
	}

}
