package programmers_lv1;

public class PRO11 {
	
	static int solution(int left, int right) {
		int answer = 0;
		int count = 0;
		for(int i = left; i <= right; i++) {
			count = pro(i);
			if(count % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}

		return answer;
	}
	
	static int pro(int num) {
		int cnt = 0;
		
		for(int i = 1; i <= num; i++) {
			if(num % i== 0) {
				cnt++;
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(13,17);
	}

}
