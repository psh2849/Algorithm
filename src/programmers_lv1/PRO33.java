package programmers_lv1;

public class PRO33 {
	static int solution(int n) {
		int answer = 0;
		
		while(n > 0) {
			int num = n % 10;
			n = n / 10;
			answer += num;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(123);
	}

}
