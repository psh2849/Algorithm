/*
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */
package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PRO23 {

	static ArrayList<Integer> solution(String s) {
		ArrayList<Integer> answer = new ArrayList<>();

		s = s.replace("{", "");
		String[] str = s.split("},");
		str[str.length-1] = str[str.length-1].replace("}", "");
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		
		for(String x : str) {
			String[] temp = x.split(",");
			
			for(int i = 0; i < temp.length; i++) {
				int n = Integer.parseInt(temp[i]);
				
				if(!answer.contains(n)) {
					answer.add(n);
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
		// solution("{{20,111},{111}}");
	}

}
