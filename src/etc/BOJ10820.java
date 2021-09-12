package etc;

import java.util.Scanner;

public class BOJ10820 {
	static String str = "";

	static void input() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			int blank = 0;
			int lower = 0;
			int upper = 0;
			int number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == ' ') {
					blank++;
				} else if (ch >= 'a' && ch <= 'z') {
					lower++;
				} else if (ch >= 'A' && ch <= 'Z') {
					upper++;
				} else {
					number++;
				}
			}
			System.out.println(lower + " " + upper + " " + number + " " + blank);
			str = "";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
