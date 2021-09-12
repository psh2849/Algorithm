package etc;

import java.util.Scanner;

public class BOJ1373 {

	static String s;

	static void input() {
		Scanner sc = new Scanner(System.in);

		s = sc.next();

		pro();

	}

	static void pro() {
		StringBuilder sb = new StringBuilder();
		int len = s.length() % 3;
		if (len == 1) {
			sb.append(s.charAt(0));
		} else if (len == 2) {
			sb.append((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));
		}

		for (int i = len; i < s.length(); i += 3) {
			sb.append((s.charAt(i) - '0') * 4 + (s.charAt(i + 1) - '0') * 2 + (s.charAt(i + 2) - '0'));
		}

		System.out.println(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
