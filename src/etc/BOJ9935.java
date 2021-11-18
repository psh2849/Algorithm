package etc;

import java.util.*;
import java.io.*;

public class BOJ9935 {

	static String origin, remove;
	static Stack<Character> stack = new Stack<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		origin = br.readLine();
		remove = br.readLine();

		for (int i = 0; i < origin.length(); i++) {
			stack.push(origin.charAt(i));

			if (stack.size() >= remove.length()) {
				boolean flag = true;

				for (int j = 0; j < remove.length(); j++) {
					if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < remove.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		for (Character ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
