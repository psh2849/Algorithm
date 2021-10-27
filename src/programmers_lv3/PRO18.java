package programmers_lv3;

public class PRO18 {
	
	static int solution(int[] stones, int k) {
		int answer = 0;
		int left = 0;
		int right = 200000000;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(check(stones, k, mid)) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				right = mid - 1;
			}
		}
		
		return answer;
	}
	
	static boolean check(int[] stones, int k, int mid) {
		int cnt = 0;
		
		for(int stone : stones) {
			if(stone - mid < 0) {
				cnt++;
			} else {
				cnt = 0;
			}
			
			if(cnt == k) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		solution(stones, 3);
	}

}
