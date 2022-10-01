package programmers_lv1;

public class PRO52 {
	static int r, t, c, f, j, m, a, n;

	public String solution(String[] survey, int[] choices) {
		String answer = "";

		for (int i = 0; i < survey.length; i++) {
			if (choices[i] > 4) {
				choice(survey[i].charAt(1), choices[i] - 4);
			} else if (choices[i] < 4) {
				choice(survey[i].charAt(0), 4 - choices[i]);
			}
		}

		answer += result('R', 'T', r, t);
		answer += result('C', 'F', c, f);
		answer += result('J', 'M', j, m);
		answer += result('A', 'N', a, n);

		return answer;
	}

	static void choice(char ch, int score) {
		if (ch == 'R') {
			r += score;
		} else if (ch == 'T') {
			t += score;
		} else if (ch == 'C') {
			c += score;
		} else if (ch == 'F') {
			f += score;
		} else if (ch == 'J') {
			j += score;
		} else if (ch == 'M') {
			m += score;
		} else if (ch == 'A') {
			a += score;
		} else if (ch == 'N') {
			n += score;
		}
	}

	static char result(char ch1, char ch2, int num1, int num2) {
		if (num1 > num2) {
			return ch1;
		} else if (num1 == num2) {
			return ch1;
		} else {
			return ch2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
