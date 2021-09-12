package programmers_lv1;

public class PRO28 {
	
	static String solution(int n) {
		String answer = "";
		
		for(int i = 0; i < n; i++) {
			if(i % 2==0) {
				answer += "¼ö";
			} else {
				answer += "¹Ú";
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
