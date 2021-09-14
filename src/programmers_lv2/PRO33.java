package programmers_lv2;

import java.util.ArrayList;
import java.util.Collections;

public class PRO33 {

	static int solution(String str1, String str2) {
		int answer = 0;
		double union = 0;
		double intersection = 0;
		ArrayList<String> s1 = new ArrayList<>();
		ArrayList<String> s2 = new ArrayList<>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		for (int i = 0; i < str1.length() - 1; i++) {
			if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' && str1.charAt(i + 1) >= 'a'
					&& str1.charAt(i + 1) <= 'z') {
				s1.add(str1.charAt(i) + "" + str1.charAt(i + 1));
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' && str2.charAt(i + 1) >= 'a'
					&& str2.charAt(i + 1) <= 'z') {
				s2.add(str2.charAt(i) + "" + str2.charAt(i + 1));
			}
		}

		if (s1.size() == 0 && s2.size() == 0) {
			answer = 65536;
			return answer;
		}

		Collections.sort(s1);
		Collections.sort(s2);

		for (String str : s1) {
			if (s2.contains(str)) {
				intersection++;
				s2.remove(str);
			}

			union++;
		}

		while (!s2.isEmpty()) {
			s2.remove(0);
			union++;
		}

		double result = intersection / union * 65536;
		answer = (int) result;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("FRANCE", "french");
		solution("aa1+aa2", "AAAA12");
		solution("handshake", "shake hands");
		solution("E=M*C^2", "e=m*c^2");
	}

}
