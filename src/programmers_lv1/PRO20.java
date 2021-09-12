/*
 * programmers https://programmers.co.kr/learn/courses/30/lessons/67256
 */
package programmers_lv1;

public class PRO20 {
	static int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
	static String hand = "right";
	static int leftHand = 10, leftHandDist;
	static int rightHand = 12, rightHandDist;

	static String solution(int[] numbers, String hand) {
		String answer = "";

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				leftHand = numbers[i];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				rightHand = numbers[i];
			} else {
				leftHandDist = getDistance(leftHand, numbers[i]);
				rightHandDist = getDistance(rightHand, numbers[i]);

				if (leftHandDist == rightHandDist) {
					if (hand.equals("right")) {
						answer += "R";
						rightHand = numbers[i];
					} else {
						answer += "L";
						leftHand = numbers[i];
					}
				} else if (leftHandDist > rightHandDist) {
					answer += "R";
					rightHand = numbers[i];
				} else {
					answer += "L";
					leftHand = numbers[i];
				}
			}
		}

		return answer;
	}

	static int getDistance(int idx, int number) {
		number = (number == 0) ? 11 : number;
		idx = (idx == 0) ? 11 : idx;

		int x = (idx - 1) / 3;
		int y = (idx - 1) % 3;
		int x1 = (number / 3);
		int y1 = 1;

		return Math.abs(x1 - x) + Math.abs(y1 - y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(numbers, hand));
	}

}
