/*
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class PRO45 {

	static ArrayList<String> list = new ArrayList<>();
	static HashMap<String, Integer> map;

	static ArrayList<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			orders[i] = String.valueOf(charArr);
		}

		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			int max = Integer.MIN_VALUE;

			for (int j = 0; j < orders.length; j++) {
				StringBuilder sb = new StringBuilder();
				if (course[i] <= orders[j].length()) {
					pro(orders[j], sb, 0, 0, course[i]);
				}
			}
			
			for(Entry<String, Integer> entry : map.entrySet()) {
				max = Math.max(max, entry.getValue());
			}
			
			for(Entry<String, Integer> entry : map.entrySet()) {
				if(max >= 2 && entry.getValue() == max) {
					answer.add(entry.getKey());
				}
			}
		}
		
		Collections.sort(answer);
		return answer;
	}

	static void pro(String str, StringBuilder sb, int k, int count, int n) {
		if (count == n) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}
		
		for(int i = k; i < str.length(); i++) {
			sb.append(str.charAt(i));
			pro(str, sb, i + 1, count + 1, n);
			sb.delete(count, count + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		solution(orders, course);
	}

}
