/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/84325
 */
package programmers_lv1;

public class PRO7 {

	static String solution(String[] table, String[] languages, int[] preference) {
		String answer = "Z";
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < table.length; i++) {
			String[] str = table[i].split(" ");

			for (int j = 0; j < languages.length; j++) {
				for (int z = 0; z < str.length; z++) {
					if (languages[j].equals(str[z])) {
						sum += preference[j] * (6 - z); 
					}
				}
			}

			if (max < sum) {
				max = sum;
				answer = str[0]; 
			} else if(max == sum) {
				if(answer.compareTo(str[0]) > 0) {
					answer = str[0];
				}
			}
			
			sum = 0;
		}
		
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "JAVA", "JAVASCRIPT" };
		int[] preference = { 7, 5 };

		solution(table, languages, preference);
	}

}
