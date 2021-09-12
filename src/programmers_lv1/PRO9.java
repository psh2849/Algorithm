package programmers_lv1;

public class PRO9 {
	static boolean[] pocketmon = new boolean[200001];
	static int cnt = 0;
	static int answer = 0;
	
	static int solution(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if(!pocketmon[nums[i]] && cnt > answer) {
				answer++;
				pocketmon[nums[i]] = true;
			} 
		}
		
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 3, 3, 3, 2, 2, 4 };
		cnt = num.length / 2;
		solution(num);
	}

}
