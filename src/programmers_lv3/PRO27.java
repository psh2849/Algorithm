/*
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 */
package programmers_lv3;

import java.util.HashMap;

public class PRO27 {
	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		
		HashMap<String, String> parentMap = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < enroll.length; i++) {
			parentMap.put(enroll[i], referral[i]);
			map.put(enroll[i], i);
		}
		
		for(int i = 0; i < seller.length; i++) {
			String str = seller[i];
			int cost = amount[i] * 100;
			
			while(!str.equals("-")) {
				int parentValue = cost / 10;
				int myValue = cost - parentValue;
				
				answer[map.get(str)] += myValue;
				
				str = parentMap.get(str);
				cost /= 10;
				
				if(cost < 1) {
					break;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		
		solution(enroll, referral, seller, amount);
	}

}
