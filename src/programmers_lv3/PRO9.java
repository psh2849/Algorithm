/*
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.Arrays;

public class PRO9 {
	static boolean[] visit;
	static ArrayList<String> list = new ArrayList<>();
	static String[][] ticket;
	static String[] answer = {};

	static String[] solution(String[][] tickets) {
		visit = new boolean[tickets.length];
		ticket = tickets;

		Arrays.sort(ticket, (o1, o2) -> {
			if (o1[0].equals(o2[0])) {
				return o2[1].compareTo(o1[1]);
			} else {
				return o2[0].compareTo(o1[0]);
			}
		});
		
		list.add("ICN");
		dfs("ICN", 0);

		return answer;
	}

	static void dfs(String city, int count) {
		if (count == visit.length) {
			answer = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}

			return;
		}

		for (int i = 0; i < ticket.length; i++) {
			if (!visit[i] && ticket[i][0].equals(city)) {
				visit[i] = true;
				list.add(ticket[i][1]);
				dfs(ticket[i][1], count + 1);
				visit[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		solution(tickets);
	}

}
