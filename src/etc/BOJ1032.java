package etc;

import java.util.Scanner;

public class BOJ1032 {
	static int N;
	static String[] str;
	static boolean isBool = true;

	static void input() {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		N = sc.nextInt();

		str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}

		for (int i = 0; i < str[0].length(); i++) {
			isBool = true;
			for (int j = 1; j < N; j++) {
				if (str[0].charAt(i) != str[j].charAt(i)) {
					isBool = false;
				}
			}
			if(!isBool) {
				ans += "?";
			} else {
				ans += str[0].charAt(i);
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
