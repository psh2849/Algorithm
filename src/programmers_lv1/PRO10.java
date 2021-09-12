package programmers_lv1;

public class PRO10 {

	static String solution(int[][] scores) {
		String answer = "";

		for (int i = 0; i < scores.length; i++) {
			int min = 100;
			int max = 0;
			int num = scores[i][i];
			int people = scores.length;
			int sum = 0;
			boolean flag = false;
			double avg = 0;

			for (int j = 0; j < scores.length; j++) {
				if(scores[j][i] == num && i != j) {
					flag = true;
				}
				
				sum += scores[j][i];
				max = Math.max(max, scores[j][i]);
				min = Math.min(min, scores[j][i]);
			}

			if ((max == num || min == num) && !flag) {
				sum -= num;
				people--;
			}

			avg = (double) sum / people;
			System.out.println(avg);
			if (avg >= 90) {
				answer += "A";
			} else if (avg >= 80 && avg < 90) {
				answer += "B";
			} else if (avg >= 70 && avg < 80) {
				answer += "C";
			} else if (avg >= 50 && avg < 70) {
				answer += "D";
			} else {
				answer += "F";
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] score = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
//				{ 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };

		int[][] score = { { 70, 70, 70, 70 }, { 50, 50, 50, 50 }, { 70, 70, 70, 70 }, {50, 50, 50, 50} };
		String ans = solution(score);
		System.out.println(ans);
	}

}
