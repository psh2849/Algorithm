/*
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 */
package programmers_lv2;

import java.util.*;

public class PRO44 {

	static ArrayList<Integer> temp;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Map<String, List<Integer>> map = new HashMap<>();

	static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		
		List<String> list2 = new ArrayList<>(map.keySet());
	
		for(int i = 0; i < list2.size(); i++) {
			List<Integer> score = map.get(list2.get(i));
			Collections.sort(score);
		}
		
		for(int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] str = query[i].split(" ");
			
			int score = Integer.parseInt(str[1]);
			answer[i] = binarySearch(str[0], score);
		}
		return answer;
	}

	static void dfs(String str, int depth, String[] info) {
		if (depth == 4) {
			if (!map.containsKey(str)) {
				temp = new ArrayList<>();
				temp.add(Integer.parseInt(info[depth]));
				map.put(str, temp);
			} else {
				map.get(str).add(Integer.parseInt(info[depth]));
			}
		} else {
			dfs(str+"-", depth + 1, info);
			dfs(str + info[depth], depth + 1, info);
		}
	}
	
	static int binarySearch(String str, int score) {
		if(!map.containsKey(str)) return 0;
		List<Integer> scoreList = map.get(str);
		int start = 0;
		int end = scoreList.size() - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(scoreList.get(mid) < score) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return scoreList.size() - start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		solution(info, query);
	}

}
