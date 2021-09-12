package programmers_lv1;

public class PRO27 {

	static int solution(int n) {
		int answer = 0;
		
		for(int i = 2; i<=n;i++) {
			boolean isBool = pro(i);
			
			if(isBool) {
				answer++;
			}
		}

		return answer;
	}
	
	static boolean pro(int num) {
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10);
	}

}
