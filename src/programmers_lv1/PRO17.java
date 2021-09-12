package programmers_lv1;

public class PRO17 {
	
	static int[] solution(int[] arr) {
		int[] answer = new int[arr.length];
		int[] ans;
		int answer_cnt = 1;
		answer[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				continue;
			} else {
				answer[answer_cnt] = arr[i];
				answer_cnt++;
				continue;
			}
		}
		
		ans = new int[answer_cnt];
		for(int i = 0; i < answer_cnt; i++) {
			ans[i] = answer[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,3,3,0,1,1};
		solution(arr);
	}
}
