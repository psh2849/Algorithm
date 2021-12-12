package etc;

import java.util.Scanner;
import java.util.Stack;

public class BOJ7567 {

	static void input() {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String str = sc.next();
		stack.push(str.charAt(0));
		int answer = 10;
		for (int i = 1; i < str.length(); i++) {
			char ch = stack.peek();
			char plate = str.charAt(i);

			if (ch != plate) {
				answer += 10;
			} else {
				answer+=5;
			}
			stack.push(plate);
		}
		
		System.out.println(answer);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
