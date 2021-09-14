/*
 * https://programmers.co.kr/learn/courses/30/lessons/77885
 */
package programmers_lv2;

public class PRO32 {

	static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				StringBuilder sb = new StringBuilder();
				String num = Long.toBinaryString(numbers[i]);
				if(!num.contains("0")) {
					sb.append("10");
					sb.append(num.substring(1, num.length()));
				} else {
					int lastIdx = num.lastIndexOf("0");
					int firstIdx = num.indexOf("1", lastIdx);
					
					sb.append(num.substring(0, lastIdx));
					sb.append(1);
					sb.append(0 + num.substring(firstIdx + 1, num.length()));
				}
				answer[i] = Long.parseLong(sb.toString(), 2);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] numbers = { 2, 19 };
		solution(numbers);
	}

}
