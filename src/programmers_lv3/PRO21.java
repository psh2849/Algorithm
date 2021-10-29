/*
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PRO21 {
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean isBool = false;
	static int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]- o2[1];
			}
		});
		
		for(int i = 0; i < routes.length; i++) {
			if(list.size() == 0) {
				list.add(routes[i][1]);
			} else {
				for(int j = 0; j < list.size(); j++) {
					if(routes[i][0] <= list.get(j) && routes[i][1] >= list.get(j)) {
						isBool = true;
						break;
					}
				}
				
				if(!isBool) {
					list.add(routes[i][1]);
				}
			}
			
			isBool = false;
		}
		System.out.println(list.size());
		return list.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
		int[][] routes = {{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}};
		solution(routes);
	}

}
