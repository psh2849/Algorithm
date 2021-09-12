package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1251 {

	static String str, result = "";
	static String[] save = new String[3];
	static StringBuilder s = new StringBuilder();
	static ArrayList<String> list = new ArrayList<>();

	static void input() {
		Scanner sc = new Scanner(System.in);

		str = sc.nextLine();
		int len = str.length();

		for (int i = 1; i < len - 2; i++) {
			for (int j = i + 1; j < len; j++) {
				save[0] = str.substring(0, i);
				save[1] = str.substring(i, j);
				save[2] = str.substring(j, len);

				reverse(save);
			}
		}
	}

	static void reverse(String[] a) {
		String reverseStr = "";

		for (int i = 0; i < 3; i++) {
			StringBuffer sb = new StringBuffer(a[i]);
			reverseStr += sb.reverse().toString();
		}

		list.add(reverseStr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();

		Collections.sort(list);

		s.append(list.get(0));
		System.out.println(s);
	}

}
