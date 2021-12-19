package etc;

import java.util.Scanner;

public class BOJ2744 {

	static void input() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				sb.append((char) (str.charAt(i) - 32));
			}

			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				sb.append((char) (str.charAt(i) + 32));
			}
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
