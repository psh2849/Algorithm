package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11656 {

	static String str;
	static ArrayList<String> list = new ArrayList<>();

	static void input() {
		Scanner sc = new Scanner(System.in);

		str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			String substr = str.substring(i, str.length());
			list.add(substr);
		}

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
