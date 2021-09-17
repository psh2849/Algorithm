package etc;

import java.util.Scanner;
import java.util.Stack;

public class BOJ17413 {

	static void input() {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		Stack<Character> stack = new Stack<>();
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				check = true;
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) == '>') {
				check = false;
				System.out.print(str.charAt(i));
			} else if (check) {
				System.out.print(str.charAt(i));
			} else if (!check) {
				if (str.charAt(i) == ' ') {
					while (!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(str.charAt(i));
				} else {
					stack.push(str.charAt(i));
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
