package programmers_lv2;

import java.util.HashMap;

public class PRO10 {
	
	static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		for(String key: map.keySet()) {
			answer *= map.get(key) + 1;
		}
		
		return answer - 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(clothes);
	}
}
