package programmers_lv1;

public class PRO51 {

	static int solution(String[] babbling) {
		int answer = 0;
		String[] str = { "aya", "ye", "woo", "ma" };

		for (int i = 0; i < babbling.length; i++) {
			if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) continue;
			
			for(int j = 0; j < 4; j++) {
				babbling[i] = babbling[i].replace(str[j], "");
			}
			
			if(babbling[i].length() == 0) {
				answer++;
			}
		}

		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		solution(babbling);
	}

}
