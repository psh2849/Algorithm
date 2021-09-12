/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/76501
 */
package programmers_lv1;

public class PRO4 {
	
	static int sum = 0;
	static int solution(int[] absolutes, boolean[] signs) {
		for(int i = 0; i < signs.length; i++) {
			if(signs[i] == false) {
				sum += -absolutes[i];
			} else {
				sum += absolutes[i];
			}
		}
	
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int absolutes[] = {4,7,12};
		boolean signs[] = {true,false,true};
		solution(absolutes, signs);
	}

}
