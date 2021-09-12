/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/12977
 */
package programmers_lv1;

public class PRO6 {
	static int sum = 0;

	static int solution(int[] nums) {
		int answer = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for(int z = j + 1; z < nums.length; z++) {
					sum += nums[i] + nums[j] + nums[z];
					boolean isBool = isPrime(sum);
					if(isBool) {
						answer++;
					}
					sum = 0;
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

	static boolean isPrime(int arrSum) {
		for (int i = 2; i * i <= arrSum; i++) {
			if (arrSum % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 7, 6, 4 };
		solution(nums);
		
	}

}
