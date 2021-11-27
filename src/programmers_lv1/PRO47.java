package programmers_lv1;

public class PRO47 {

	static int solution(int[] numbers) {
		int answer = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}
		answer = 45 - answer;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };

		solution(numbers);
	}

}
